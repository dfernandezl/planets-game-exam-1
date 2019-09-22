import { SET_POST } from "../actions/setPost";
import reduceSetPost from "./reduceSetPost";

function reduceBlog(state = {}, action) {
  switch (action.type) {
    case SET_POST:
      return reduceSetPost(state, action);
    default:
      return state;
  }
}

export default reduceBlog;
