import getCommands from "./getCommands";

const EMPTY = {};
export default function getEntityCommands(state, { entityId }) {
  const commands = getCommands(state);
  return commands[entityId] || EMPTY;
}
