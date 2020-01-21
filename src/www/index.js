import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import "bootswatch/dist/darkly/bootstrap.css";
import { makeApp } from "./makeApp";
import * as serviceWorker from "./serviceWorker";

const appCompose =
  window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ &&
  window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({ trace: true, traceLimit: 25 });
const App = makeApp(undefined, appCompose);
ReactDOM.render(<App />, document.getElementById("root"));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
