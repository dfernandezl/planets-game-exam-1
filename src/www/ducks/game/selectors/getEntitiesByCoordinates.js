import { createSelector } from "reselect";
import { listEntities } from "./listEntities";
import { groupBy } from "../../../lib";

function makeGetEntitiesByCoordinates() {
  return createSelector(listEntities, entities =>
    groupBy(entities, e => `${e.row},${e.column}`),
  );
}

export const getEntitiesByCoordinates = makeGetEntitiesByCoordinates();
