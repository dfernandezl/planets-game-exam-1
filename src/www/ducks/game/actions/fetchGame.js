export const FETCH_GAME = "game/FETCH";
export default function fetchGame(playerId) {
  return {
    type: FETCH_GAME,
    playerId,
  };
}
