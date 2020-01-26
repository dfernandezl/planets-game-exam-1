import React, { useCallback } from "react";
import { Form, Card } from "react-bootstrap";
import { useCommandValue } from "../../ducks";

export function SatelliteCommand({ entity }) {
  const [upgrade, setUpgrade] = useCommandValue(entity.id, "UpgradeSatellite", 0);
  const onUpgrade = useCallback(ev => setUpgrade(ev.target.value), [setUpgrade]);

  return (
    <>
      <Card.Body>
        <Form.Group controlId="shipUpgrade">
          <Form.Label>Upgrade satellite</Form.Label>
          <Form.Control
            value={upgrade}
            onChange={onUpgrade}
            placeholder="Amount of people"
          />
        </Form.Group>
      </Card.Body>
    </>
  );
}
