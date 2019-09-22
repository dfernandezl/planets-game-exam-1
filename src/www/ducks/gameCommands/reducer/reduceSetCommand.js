export default function reduceSetCommand(state, action) {
  const { command } = action;
  const { entityId, type } = command;
  return {
    ...state,
    [entityId]: {
      ...state[entityId],
      [type]: {
        ...(state[entityId] && state[entityId][type]),
        ...command,
      },
    },
  };
}
