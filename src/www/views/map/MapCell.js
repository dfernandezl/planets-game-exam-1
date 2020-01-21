import React, { useMemo } from "react";
import { css } from "emotion";
import { useDispatch, useSelect } from "../../lib";
import { CELL_WIDTH, CELL_HEIGHT } from "./";
import {
  listEntitiesAtCoordinate,
  getEntitiesAtCoordinateByType,
  getPlayerId,
  setView,
  getView,
} from "../../ducks";

const cellClassName = css`
  width: ${CELL_WIDTH}em;
  height: ${CELL_HEIGHT}em;
  border: dashed 1px rgba(255, 255, 0, 0.2);
  display: flex;
  align-items: center;
  justify-content: center;

  &.yours {
    background: rgba(0, 128, 256, 0.3);
  }

  &.highlighted {
    background: rgba(255, 255, 128, 0.3);
  }
`;

export function MapCell({ row, column }) {
  const byType = useSelect(getEntitiesAtCoordinateByType, { row, column });
  const entities = useSelect(listEntitiesAtCoordinate, { row, column });
  const playerId = useSelect(getPlayerId);
  const onClickCell = useDispatch(setView, { coordinates: { row, column } });
  const coordinates = useSelect(getView, "coordinates");

  return useMemo(() => {
    const style = {
      width: `${CELL_WIDTH}em`,
      height: `${CELL_HEIGHT}em`,
      left: `${CELL_WIDTH * (column - 1)}em`,
      top: `${CELL_HEIGHT * (row - 1)}em`,
      position: "absolute",
    };

    // ✦ ★ ✶ ✸ ✹ ✺ ✨  sun ☀ ✾ ⭐🌏🌑🌕🌋💫🗼	🪐
    const contents = [];
    if (byType["starbase"]) {
      contents.push(
        <span data-testid="starbases" key="starbases" className="text-success">
          ⌔
        </span>,
      );
    }
    if (byType["star"]) {
      contents.push(
        <span data-testid="star" key="star" className="text-warning">
          ●
        </span>,
      );
    }
    if (byType["ship"]) {
      contents.push(
        <span data-testid="ships" key="ships" className="text-primary">
          ▶
        </span>,
      );
    }

    let className = cellClassName;
    if (entities.some(e => e.playerId === playerId)) {
      className += " yours";
    }

    if (
      coordinates &&
      coordinates.row === row &&
      coordinates.column === column
    ) {
      className += " highlighted";
    }

    return (
      <div
        data-testid={`${row},${column}`}
        style={style}
        className={className}
        onClick={onClickCell}
        title={`${row},${column}`}
      >
        {contents}
      </div>
    );
  }, [coordinates, row, column, byType, entities, playerId, onClickCell]);
}
