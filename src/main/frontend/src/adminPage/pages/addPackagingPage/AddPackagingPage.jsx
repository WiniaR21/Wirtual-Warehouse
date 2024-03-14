import React from "react";
import addPagesStyles from "../addPagesStyles";
export const AddPackagingPage = () => {
  return (
    <div style={addPagesStyles.container}>
      <h2>Wprowadź nazwe opakowania</h2>
      <input
        type="text"
        placeholder="Nazwa opakowania"
        style={addPagesStyles.input}
      />
      <input
        type="text"
        placeholder="Waga opakowania"
        style={addPagesStyles.input}
      />
      <input
        type="text"
        placeholder="Objętość opakowania bez materiału"
        style={addPagesStyles.input}
      />
      {/* Dodaj inne pola formularza, jeśli potrzebujesz */}
      <button style={addPagesStyles.button}>Dodaj opakowanie</button>
    </div>
  );
};
