export const FETCH_GAME = "game/FETCH";
export function fetchGame(playerId) {
  return {
    type: FETCH_GAME,
    playerId,
  };
}
