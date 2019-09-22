import api from "../../../lib/api";
import { setPost } from "../actions/setPost";

function removeOneLineComments(body) {
  return body
    .split("\n")
    .filter(line => !/^\s*<!--.*-->\s*$/.test(line))
    .join("\n");
}

async function whenFetchPost(store, action) {
  const { postId } = action;
  const post = await api.get(`/api/v1/posts/${postId}`);
  post.body = removeOneLineComments(post.body);
  store.dispatch(setPost(post));
}

export default whenFetchPost;
