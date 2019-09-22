import React, { useCallback } from "react";
import { ButtonGroup, Button, Card } from "react-bootstrap";
import { useCommandValue } from "../../ducks/gameCommands/hooks/useCommandValue";

export default function ShipCommand({ entity }) {
  const [direction, move] = useCommandValue(entity.id, "MoveShip");
  const moveDown = useCallback(() => move("down"), [move]);
  const moveUp = useCallback(() => move("up"), [move]);
  const moveLeft = useCallback(() => move("left"), [move]);
  const moveRight = useCallback(() => move("right"), [move]);

  return (
    <Card.Body>
      Move ship:
      <ButtonGroup>
        <Button
          onClick={moveDown}
          data-testid="go-down"
          active={direction === "down"}
        >
          v
        </Button>
        <Button
          onClick={moveUp}
          data-testid="go-up"
          active={direction === "up"}
        >
          ^
        </Button>
        <Button
          onClick={moveLeft}
          data-testid="go-left"
          active={direction === "left"}
        >
          &lt;
        </Button>
        <Button
          onClick={moveRight}
          data-testid="go-right"
          active={direction === "right"}
        >
          &gt;
        </Button>
      </ButtonGroup>
    </Card.Body>
  );
}
