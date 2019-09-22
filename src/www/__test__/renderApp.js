import React from "react";
import { render } from "@testing-library/react";
import "@testing-library/jest-dom/extend-expect";
import makeApp from "../makeApp";

export default function renderApp() {
  const App = makeApp();
  return render(<App />);
}
