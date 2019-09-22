export const SET_COMMAND = "gameCommands/SET";
export function setCommand(entityId, type, value) {
  return {
    type: SET_COMMAND,
    command: {
      entityId,
      type,
      value,
    },
  };
}
