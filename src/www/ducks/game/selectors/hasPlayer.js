import { getPlayerId } from "./getPlayerId";

export function hasPlayer(state) {
  const playerId = getPlayerId(state);
  return !!playerId;
}
