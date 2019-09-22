import { createSelector } from "reselect";
import listEntities from "./listEntities";
import groupBy from "../../../lib/groupBy";

function makeGetEntitiesByCoordinates() {
  return createSelector(
    listEntities,
    entities => groupBy(entities, e => `${e.row},${e.column}`),
  );
}

const getEntitiesByCoordinates = makeGetEntitiesByCoordinates();
export default getEntitiesByCoordinates;
