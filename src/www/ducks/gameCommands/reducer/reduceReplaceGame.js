import groupBy from "../../../lib/groupBy";
import indexBy from "../../../lib/indexBy";

export default function reduceReplaceGame(state, action) {
  const { game } = action;
  const commands = game.commands;

  const nextState = groupBy(commands, "entityId");
  Object.keys(nextState).forEach(entityId => {
    nextState[entityId] = indexBy(nextState[entityId], "type");
  });
  return nextState;
}
