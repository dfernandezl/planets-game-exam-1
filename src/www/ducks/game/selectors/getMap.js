import getGame from "./getGame";

export default function getMap(state) {
  const game = getGame(state);
  return game && game.map;
}
