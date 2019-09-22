import getGame from "./getGame";

export default function getRace(state) {
  const game = getGame(state);
  return game && game.race;
}
