import { getGame } from "./getGame";

export function getMap(state) {
  const game = getGame(state);
  return game && game.map;
}
