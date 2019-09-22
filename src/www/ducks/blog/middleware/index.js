import { FETCH_POST_LIST } from "../actions/fetchPostList";
import whenFetchPostList from "./whenFetchPostList";
import { FETCH_POST } from "../actions/fetchPost";
import whenFetchPost from "./whenFetchPost";

const blogMiddleware = state => next => async action => {
  next(action);

  switch (action.type) {
    case FETCH_POST:
      return whenFetchPost(state, action);
    case FETCH_POST_LIST:
      return whenFetchPostList(state, action);
    default: // nothing
  }
};

export default blogMiddleware;
