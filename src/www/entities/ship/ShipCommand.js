import React, { useCallback } from "react";
import { Form, Card } from "react-bootstrap";
import { MoveShipCommand } from "./MoveShipCommand";
import { useCommandValue } from "../../ducks";

export function ShipCommand({ entity }) {
  const [load, setLoad] = useCommandValue(entity.id, "LoadShip", 0);
  const onLoad = useCallback(ev => setLoad(ev.target.value), [setLoad]);

  return (
    <>
      <Card.Body>
        <Form.Group controlId="shipLoad">
          <Form.Label>Load</Form.Label>
          <Form.Control
            value={load}
            onChange={onLoad}
            placeholder="Amount of people"
          />
        </Form.Group>
      </Card.Body>
      <MoveShipCommand entity={entity} />
    </>
  );
}
