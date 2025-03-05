import { createRoot } from "react-dom/client";
import "./index.css";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import LoginPage from "./pages/login/index.jsx";
import RegisterPage from "./pages/register/index.jsx";
import { ToastContainer } from "react-toastify";

import ManageBooking from "./pages/admin/manage-booking.jsx";
import ManageUser from "./pages/admin/manage-user.jsx";
import AdminLayout from "./components/layouts/adminLayout.jsx";

<import>RouterProvider,</import>;

const router = createBrowserRouter([
  {
    path: "/login",
    element: <LoginPage />,
  },
  {
    path: "/register",
    element: <RegisterPage />,
  },
  // {
  //   path: "/dashboard",
  //   element: <AdminLayout/>,
  //   children:[
  //     {
  //       path: "/dashboard/booking",
  //       element: <ManageBooking/>
  //     },
  //     {
  //       path: "/dashboard/user",
  //       element: <ManageUser/>
  //     },
  //   ]
  // },
]);

createRoot(document.getElementById("root")).render(
  <>
    <RouterProvider router={router} />
    <ToastContainer />
  </>
);
