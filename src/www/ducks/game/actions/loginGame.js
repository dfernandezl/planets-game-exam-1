export const LOGIN_GAME = "game/LOGIN";
export default function loginGame(playerId) {
  return {
    type: LOGIN_GAME,
    playerId,
  };
}
