function reduceSetPost(state, action) {
  const { post } = action;
  const { id } = post;
  return { ...state, [id]: { ...state[id], ...post } };
}

export default reduceSetPost;
