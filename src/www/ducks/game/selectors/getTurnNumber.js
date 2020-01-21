import { getMap } from "./getMap";

export function getTurnNumber(state) {
  const map = getMap(state);
  return map && map.turnNumber;
}
