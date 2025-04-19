import React, { useState, useEffect } from "react";
import axios from "axios";
import "./Cards.css";
import Card from "../Card/Card";
import {
  UilUsdSquare,
  UilMoneyWithdrawal,
  UilClipboardAlt,
} from "@iconscout/react-unicons";

const Cards = () => {
  const [cardsDataValues, setCardsDataValues] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          "http://127.0.0.1:8000/api/cards-data-values"
        );
        setCardsDataValues(response.data);
        console.log(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  const cardsData = [
    {
      title: "账单",
      color: {
        backGround:
          "linear-gradient(rgb(248, 212, 154) -146.42%, rgb(255 202 113) -46.42%)",
        boxShadow: "0px 10px 20px 0px #e0c6f5",
      },
      barValue: cardsDataValues.barValue1 || 0,
      value: cardsDataValues.value1 || "0",
      png: UilUsdSquare,
    },
    {
      title: "仓储量",
      color: {
        backGround: "linear-gradient(180deg, #FF919D 0%, #FC929D 100%)",
        boxShadow: "0px 10px 20px 0px #FDC0C7",
      },
      barValue: cardsDataValues.barValue2 || 0,
      value: cardsDataValues.value2 || "0",
      png: UilMoneyWithdrawal,
    },
    {
      title: "已售出",
      color: {
        backGround: "linear-gradient(180deg, #bb67ff 0%, #c484f3 100%)",
        boxShadow: "0px 10px 20px 0px #F9D59B",
      },
      barValue: cardsDataValues.barValue3 || 0,
      value: cardsDataValues.value3 || "0",
      png: UilClipboardAlt,
    },
  ];

  return (
    <div className="Cards">
      {cardsData.map((card, id) => {
        return (
          <div className="parentContainer" key={id}>
            <Card
              title={card.title}
              color={card.color}
              barValue={card.barValue}
              value={card.value}
              png={card.png}
              series={card.series}
            />
          </div>
        );
      })}
    </div>
  );
};

export default Cards;
