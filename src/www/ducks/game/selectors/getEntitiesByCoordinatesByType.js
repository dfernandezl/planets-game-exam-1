import { createSelector } from "reselect";
import { groupBy } from "../../../lib";
import { listEntitiesAtCoordinate } from "./listEntitiesAtCoordinate";

function makeGetEntitiesAtCoordinateByType() {
  return createSelector(listEntitiesAtCoordinate, entities =>
    groupBy(entities, "type"),
  );
}

export const getEntitiesAtCoordinateByType = makeGetEntitiesAtCoordinateByType();
