import { createSelector } from "reselect";
import groupBy from "../../../lib/groupBy";
import listEntitiesAtCoordinate from "./listEntitiesAtCoordinate";

function makeGetEntitiesAtCoordinateByType() {
  return createSelector(
    listEntitiesAtCoordinate,
    entities => groupBy(entities, "type"),
  );
}

const getEntitiesAtCoordinateByType = makeGetEntitiesAtCoordinateByType();
export default getEntitiesAtCoordinateByType;
