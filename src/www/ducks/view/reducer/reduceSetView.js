export function reduceSetView(state, action) {
  const { view } = action;
  return { ...state, ...view };
}
