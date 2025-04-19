import React, { useState, useEffect } from "react";
import axios from "axios";
import "./Updates.css";

const Updates = () => {
  const [updatesData, setUpdatesData] = useState([]);

  useEffect(() => {
    const fetchUpdatesData = async () => {
      try {
        const response = await axios.get(
          "http://127.0.0.1:8000/api/updates-data"
        );
        setUpdatesData(response.data);
      } catch (error) {
        console.error("Error fetching updates data:", error);
      }
    };

    fetchUpdatesData();
  }, []);

  return (
    <div className="Updates">
      {updatesData.map((update) => {
        return (
          <div className="update" key={update.id}>
            <div className="noti">
              <div style={{ marginBottom: "0.5rem" }}>
                <span>{update.name}</span>
                <span> {update.noti}</span>
              </div>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default Updates;
