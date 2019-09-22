import { SET_VIEW } from "../actions/setView";
import reduceSetView from "./reduceSetView";

function reduceView(state = { root: "Home" }, action) {
  switch (action.type) {
    case SET_VIEW:
      return reduceSetView(state, action);
    default:
      return state;
  }
}

export default reduceView;
