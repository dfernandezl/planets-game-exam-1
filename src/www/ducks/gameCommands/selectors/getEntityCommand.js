import getEntityCommands from "./getEntityCommands";

export default function getEntityCommand(state, { entityId, type }) {
  const commands = getEntityCommands(state, { entityId });
  return commands[type];
}
