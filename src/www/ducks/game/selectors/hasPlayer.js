import getPlayerId from "./getPlayerId";

export default function hasPlayer(state) {
  const playerId = getPlayerId(state);
  return !!playerId;
}
