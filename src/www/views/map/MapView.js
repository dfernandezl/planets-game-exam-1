import React, { useMemo } from "react";
import useSelect from "../../lib/useSelect";
import getMap from "../../ducks/game/selectors/getMap";
import { CELL_WIDTH, CELL_HEIGHT } from "./mapConstants";
import MapCell from "./MapCell";
import range from "../../lib/range";

export default function MapView() {
  const map = useSelect(getMap);

  return useMemo(() => {
    const style = {
      width: `${CELL_WIDTH * map.columns}em`,
      height: `${CELL_HEIGHT * map.rows}em`,
      position: "relative",
      background: "rgba(0,0,0,.1)",
      margin: "1em auto 0",
    };

    return (
      <div data-testid="map-of-the-game" style={style}>
        {range(1, map.rows).flatMap(row =>
          range(1, map.columns).map(column => (
            <MapCell row={row} column={column} key={`${row},${column}`} />
          )),
        )}
      </div>
    );
  }, [map]);
}
