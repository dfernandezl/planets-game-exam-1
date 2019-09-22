export const FETCH_POST = "blog/FETCH_POST";
export function fetchPost(postId) {
  return {
    type: FETCH_POST,
    postId
  };
}
