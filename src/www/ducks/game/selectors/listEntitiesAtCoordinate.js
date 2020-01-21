import { getEntitiesByCoordinates } from "./getEntitiesByCoordinates";

const EMPTY = [];
export function listEntitiesAtCoordinate(state, coordinates) {
  const { row, column } = coordinates;
  return getEntitiesByCoordinates(state)[`${row},${column}`] || EMPTY;
}
