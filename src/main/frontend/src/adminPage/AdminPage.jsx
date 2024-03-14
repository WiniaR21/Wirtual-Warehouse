import React from "react";
import "./admin-page.css";
import MainAdminLeftBar from "./left-bar/MainAdminLeftBar";
import BigLorem from "./BigLorem";

const AdminPage = () => {
  return (
    <>
      <div className="admin-page">
        <div className="left-bar">
          <MainAdminLeftBar />
        </div>
        <div className="content">
          <div className="section">
            <h2>Rodzaje produktów które produkuje twoja firma</h2>
            <BigLorem />
            <BigLorem />
            <BigLorem />
          </div>
          <div className="section">
            <h2>Opakowania których używa twoja firma</h2>
            <BigLorem />
          </div>
          <div className="section">
            <h2>Statusy produktów którymi posługuje się twoja firma</h2>
            <BigLorem />
          </div>
          <div className="section">
            <h2>Działy w twojej firmie</h2>
            <BigLorem />
          </div>
        </div>
      </div>
    </>
  );
};

export default AdminPage;
