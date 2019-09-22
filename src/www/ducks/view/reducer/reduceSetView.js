function reduceSetView(state, action) {
  const { view } = action;
  return { ...state, ...view };
}

export default reduceSetView;
