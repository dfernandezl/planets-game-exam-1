export const LOGIN_GAME = "game/LOGIN";
export function loginGame(playerId) {
  return {
    type: LOGIN_GAME,
    playerId,
  };
}
