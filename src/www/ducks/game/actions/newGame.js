export const NEW_GAME = "game/NEW";
export default function newGame(mapCode, players) {
  return {
    type: NEW_GAME,
    mapCode,
    players,
  };
}
