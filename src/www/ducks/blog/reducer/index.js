import { SET_POST } from "../actions";
import { reduceSetPost } from "./private";

export function reduceBlog(state = {}, action) {
  switch (action.type) {
    case SET_POST:
      return reduceSetPost(state, action);
    default:
      return state;
  }
}
