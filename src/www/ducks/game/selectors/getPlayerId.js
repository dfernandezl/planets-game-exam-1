import getGame from "./getGame";

export default function getPlayerId(state) {
  const game = getGame(state);
  return game && game.playerId;
}
