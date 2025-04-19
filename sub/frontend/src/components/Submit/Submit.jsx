import React, { useState } from "react";
import "./Submit.css";

const Submit = () => {
  const [productCount, setProductCount] = useState(1);
  const [productList, setProductList] = useState([{ id: 1 }]);
  const [startTime, setStartTime] = useState("");
  const [endTime, setEndTime] = useState("");

  const handleProductCountChange = (e) => {
    const count = parseInt(e.target.value);
    if (isNaN(count) || count < 1) {
      return;
    }
    setProductCount(count);
  };

  const handleProductListChange = (e, index) => {
    const { name, value } = e.target;
    setProductList((prevState) => {
      const newState = [...prevState];
      newState[index][name] = value;
      return newState;
    });
  };

  const handleAddProduct = () => {
    setProductList((prevState) => [...prevState, { id: prevState.length + 1 }]);
    setProductCount(productCount + 1);
  };

  const handleRemoveProduct = () => {
    if (productCount === 1) {
      return;
    }
    setProductList((prevState) => prevState.slice(0, -1));
    setProductCount(productCount - 1);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const items = productList.map((product) => {
      return {
        name: product.name,
        product_id: product.id,
        quantity: parseInt(product.quantity) || 0,
        unit_price: parseInt(product.unit_price) || 0,
      };
    });

    const data = {
      seller: "20301038",
      items: items,
      start_time: e.target["start-time"].value,
      end_time: e.target["end-time"].value,
    };

    console.log(JSON.stringify(data));

    try {
      const response = await fetch("http://127.0.0.1:8000/submit", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });

      if (response.ok) {
        console.log("Data has been submitted successfully");
      } else {
        console.log("Failed to submit data");
      }
    } catch (error) {
      console.error("Error while submitting data", error);
    }
  };

  return (
    <div className="submit-container">
      <form onSubmit={handleSubmit}>
        {productList.map((product, index) => (
          <div key={product.id}>
            <h3>产品{index + 1}</h3>
            <div className="form-group">
              <label htmlFor={`product-${index}-name`}>名称</label>
              <input
                type="text"
                id={`product-${index}-name`}
                name="name"
                onChange={(e) => handleProductListChange(e, index)}
              />
            </div>
            <div className="form-group">
              <label htmlFor={`product-${index}-count`}>数量</label>
              <input
                type="number"
                id={`product-${index}-count`}
                name="quantity"
                onChange={(e) => handleProductListChange(e, index)}
              />
            </div>
            <div className="form-group">
              <label htmlFor={`product-${index}-price`}>单价</label>
              <input
                type="number"
                id={`product-${index}-price`}
                name="unit_price"
                onChange={(e) => handleProductListChange(e, index)}
              />
            </div>
          </div>
        ))}
        <div className="form-group">
          <button type="button" onClick={handleAddProduct}>
            添加产品
          </button>
          <button type="button" onClick={handleRemoveProduct}>
            删除产品
          </button>
        </div>
        <div className="form-group">
          <label htmlFor="start-time">开始存放时间</label>
          <input
            type="date"
            id="start-time"
            name="start-time"
            value={startTime}
            onChange={(e) => setStartTime(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="end-time">截止存放时间</label>
          <input
            type="date"
            id="end-time"
            name="end-time"
            value={endTime}
            onChange={(e) => setEndTime(e.target.value)}
          />
        </div>
        <div className="form-group">
          <button className="submit-btn" type="submit">
            提交
          </button>
        </div>
      </form>
    </div>
  );
};

export default Submit;
