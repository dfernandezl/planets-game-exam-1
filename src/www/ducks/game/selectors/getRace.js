import { getGame } from "./getGame";

export function getRace(state) {
  const game = getGame(state);
  return game && game.race;
}
