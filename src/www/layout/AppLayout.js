import React from "react";
import { Alert } from "../ducks";
import { Header, Version } from "./";

export function AppLayout({ children }) {
  return (
    <>
      <Version />
      <Header />
      <Alert />
      {children}
    </>
  );
}
