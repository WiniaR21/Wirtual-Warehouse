import React from "react";
import addPagesStyles from "../addPagesStyles";
export const AddProductNamePage = () => {
  return (
    <div style={addPagesStyles.container}>
      <h2>Wprowadź nazwe produktu</h2>
      <input
        type="text"
        placeholder="Nazwa produktu"
        style={addPagesStyles.input}
      />
      {/* Dodaj inne pola formularza, jeśli potrzebujesz */}
      <button style={addPagesStyles.button}>Dodaj produkt</button>
    </div>
  );
};
