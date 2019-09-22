import getGame from "./getGame";

export default function listEntities(state) {
  const game = getGame(state);
  return game && game.entities;
}
