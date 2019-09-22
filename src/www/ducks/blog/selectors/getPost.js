import getBlog from "./getBlog";

function getPost(state, { postId }) {
  return getBlog(state)[postId];
}

export default getPost;
