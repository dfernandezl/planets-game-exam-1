import { getGame } from "./getGame";

export function getPlayerId(state) {
  const game = getGame(state);
  return game && game.playerId;
}
