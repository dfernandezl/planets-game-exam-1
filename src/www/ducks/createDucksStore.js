import { applyMiddleware, compose, createStore } from "redux";
import thunk from "redux-thunk";
import ducksReducer from "ducks-reducer";
import ducksMiddleware from "ducks-middleware";
import freezeReducer from "../lib/freezeReducer";

import ducks from "./index";

function createDucksStore(preloadedState, appCompose = compose) {
  const appReducer = freezeReducer(ducksReducer(ducks));
  const appMiddleware = ducksMiddleware(ducks);

  return createStore(
    appReducer,
    preloadedState,
    appCompose(applyMiddleware(thunk, appMiddleware))
  );
}

export default createDucksStore;
