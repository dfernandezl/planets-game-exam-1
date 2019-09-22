import React from "react";
import Header from "./Header";
import Version from "./Version";
import Alert from "../ducks/alert/components/Alert";

function AppLayout({ children }) {
  return (
    <>
      <Version />
      <Header />
      <Alert />
      {children}
    </>
  );
}

export default AppLayout;
