import { getCommands } from "./getCommands";

const EMPTY = {};
export function getEntityCommands(state, { entityId }) {
  const commands = getCommands(state);
  return commands[entityId] || EMPTY;
}
