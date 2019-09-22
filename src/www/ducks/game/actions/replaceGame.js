export const REPLACE_GAME = "game/REPLACE";
export default function replaceGame(game) {
  return {
    type: REPLACE_GAME,
    game,
  };
}
