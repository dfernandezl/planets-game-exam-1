import React, { useCallback } from "react";
import { Form, Card } from "react-bootstrap";
import { useCommandValue } from "../../ducks/gameCommands/hooks/useCommandValue";

export default function StarbaseCommand({ entity }) {
  const [shipName, setShipName] = useCommandValue(entity.id, "BuildShip", "");
  const onShipName = useCallback(ev => setShipName(ev.target.value), [
    setShipName,
  ]);

  return (
    <>
      <Card.Body>
        <Form.Group controlId={"newShipName" + entity.id}>
          <Form.Label>New ship name</Form.Label>
          <Form.Control
            type="text"
            value={shipName}
            onChange={onShipName}
            placeholder="Ships name"
          />
        </Form.Group>
      </Card.Body>
    </>
  );
}
