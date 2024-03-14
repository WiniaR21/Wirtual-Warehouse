import React from "react";
import addPagesStyles from "../addPagesStyles";
const AddStatusPage = () => {
  return (
    <div style={addPagesStyles.container}>
      <h2>Wprowadź status produktu</h2>
      <input type="text" placeholder="Status" style={addPagesStyles.input} />
      {/* Dodaj inne pola formularza, jeśli potrzebujesz */}
      <button style={addPagesStyles.button}>Dodaj status</button>
    </div>
  );
};

export default AddStatusPage;
