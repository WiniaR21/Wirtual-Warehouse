import React from "react";
import addPagesStyles from "../addPagesStyles";

const AddDepartmentPage = () => {
  return (
    <div style={addPagesStyles.container}>
      <h2>Wprowadź nazwe działu</h2>
      <input
        type="text"
        placeholder="Nazwa działu"
        style={addPagesStyles.input}
      />
      <input
        type="text"
        placeholder="Pojemność działu"
        style={addPagesStyles.input}
      />
      {/* Dodaj inne pola formularza, jeśli potrzebujesz */}
      <button style={addPagesStyles.button}>Dodaj dział</button>
    </div>
  );
};

export default AddDepartmentPage;
