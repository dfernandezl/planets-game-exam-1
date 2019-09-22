import getMap from "./getMap";

export default function getTurnNumber(state) {
  const map = getMap(state);
  return map && map.turnNumber;
}
