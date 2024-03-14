import React from "react";
import LeftBarOption from "./left-bar-option/LeftBarOption";

const MainAdminLeftBar = () => {
  return (
    <div className="left-bar">
      <div className="left-bar-space">Wirtualny Magazyn | ADMIN</div>
      <LeftBarOption option="Nowy produkt" link="addProductName" />
      <LeftBarOption option="Nowe opakowanie" link="addPackaging" />
      <LeftBarOption option="Nowy status" link="addStatus" />
      <LeftBarOption option="Nowy dział" link="addDepartment" />
    </div>
  );
};

export default MainAdminLeftBar;
