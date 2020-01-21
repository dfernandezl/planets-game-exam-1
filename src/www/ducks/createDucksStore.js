import { applyMiddleware, compose, createStore } from "redux";
import thunk from "redux-thunk";
import ducksReducer from "ducks-reducer";
import ducksMiddleware from "ducks-middleware";
import { freezeReducer } from "../lib";

import { appDucks } from "./";

export function createDucksStore(preloadedState, appCompose = compose) {
  const appReducer = freezeReducer(ducksReducer(appDucks));
  const appMiddleware = ducksMiddleware(appDucks);

  return createStore(
    appReducer,
    preloadedState,
    appCompose(applyMiddleware(thunk, appMiddleware)),
  );
}
