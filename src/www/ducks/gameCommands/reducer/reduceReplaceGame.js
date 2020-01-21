import { groupBy, indexBy } from "../../../lib";

export function reduceReplaceGame(state, action) {
  const { game } = action;
  const commands = game.commands;

  const nextState = groupBy(commands, "entityId");
  Object.keys(nextState).forEach(entityId => {
    nextState[entityId] = indexBy(nextState[entityId], "type");
  });
  return nextState;
}
