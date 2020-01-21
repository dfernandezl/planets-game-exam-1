export const REPLACE_GAME = "game/REPLACE";
export function replaceGame(game) {
  return {
    type: REPLACE_GAME,
    game,
  };
}
