import { getBlog } from "./getBlog";

export function getPost(state, { postId }) {
  return getBlog(state)[postId];
}
