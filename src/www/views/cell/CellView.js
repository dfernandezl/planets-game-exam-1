import React, { useMemo } from "react";
import { useDispatch, useSelect } from "../../lib";
import { setView, getView, listEntitiesAtCoordinate } from "../../ducks";
import { Entities } from "../../entities";

export function CellView() {
  const onBack = useDispatch(setView, { coordinates: null });
  const coordinates = useSelect(getView, "coordinates");
  const entities = useSelect(listEntitiesAtCoordinate, coordinates);

  return useMemo(() => {
    return (
      <>
        {coordinates && <button onClick={onBack}>Back</button>}
        <Entities entities={entities} />
      </>
    );
  }, [coordinates, entities, onBack]);
}
