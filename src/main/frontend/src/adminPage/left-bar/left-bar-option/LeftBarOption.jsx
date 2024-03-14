import React from "react";
import { Link } from "react-router-dom";

const LeftBarOption = (props) => {
  return (
    <div className="left-bar-option">
      <Link to={props.link} className="link">
        {props.option}
      </Link>
    </div>
  );
};

export default LeftBarOption;
