import React, { useMemo } from "react";
import useSelect from "../../lib/useSelect";
import getView from "../../ducks/view/selectors/getView";
import useDispatch from "../../lib/useDispatch";
import { setView } from "../../ducks/view/actions/setView";
import listEntitiesAtCoordinate from "../../ducks/game/selectors/listEntitiesAtCoordinate";
import Entities from "../../entities/Entities";

export default function CellView() {
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
