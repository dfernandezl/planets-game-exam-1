import { FETCH_POST, FETCH_POST_LIST } from "../actions";
import { whenFetchPost, whenFetchPostList } from "./private";

export const blogMiddleware = state => next => async action => {
  next(action);

  switch (action.type) {
    case FETCH_POST:
      return whenFetchPost(state, action);
    case FETCH_POST_LIST:
      return whenFetchPostList(state, action);
    default: // nothing
  }
};
