import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import AdminPage from "./adminPage/AdminPage";
import { AddProductNamePage } from "./adminPage/pages/addProductNamePage/AddProductNamePage";
import { AddPackagingPage } from "./adminPage/pages/addPackagingPage/AddPackagingPage";
import AddDepartmentPage from "./adminPage/pages/addDepartmentPage/AddDepartmentPage";
import AddStatusPage from "./adminPage/pages/addStatusPage/AddStatusPage";

const router = createBrowserRouter([
  {
    path: "/admin",
    element: <AdminPage />,
  },
  {
    path: "admin/addProductName",
    element: <AddProductNamePage />,
  },
  {
    path: "admin/addPackaging",
    element: <AddPackagingPage />,
  },
  {
    path: "admin/addStatus",
    element: <AddStatusPage />,
  },
  {
    path: "admin/addDepartment",
    element: <AddDepartmentPage />,
  },
]);
ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
