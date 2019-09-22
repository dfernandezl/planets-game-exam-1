export const SET_POST = "blog/SET_POST";
export function setPost(post) {
  return {
    type: SET_POST,
    post
  };
}
