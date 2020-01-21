import { getGame } from "./getGame";

export function getMessages(state) {
  const game = getGame(state);
  return game && game.messages;
}
