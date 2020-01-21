import { getGame } from "./getGame";

export function listEntities(state) {
  const game = getGame(state);
  return game && game.entities;
}
