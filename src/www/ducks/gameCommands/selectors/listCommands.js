import { createSelector } from "reselect";
import getCommands from "./getCommands";

function compareCommands(a, b) {
  if (a.entityId < b.entityId) return -1;
  if (a.entityId > b.entityId) return +1;
  if (a.type < b.type) return -1;
  if (a.type > b.type) return +1;
  return 0;
}

const listCommands = createSelector(getCommands, commands =>
  Object.keys(commands)
    .flatMap(entityId => Object.values(commands[entityId]))
    .sort(compareCommands),
);

export default listCommands;
