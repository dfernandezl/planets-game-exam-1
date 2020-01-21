import { SET_VIEW } from "../actions";
import { reduceSetView } from "./private";

export function reduceView(state = { root: "Home" }, action) {
  switch (action.type) {
    case SET_VIEW:
      return reduceSetView(state, action);
    default:
      return state;
  }
}

export default reduceView;
