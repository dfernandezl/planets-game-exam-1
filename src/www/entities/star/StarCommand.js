import React, { useCallback } from "react";
import { Form, Card } from "react-bootstrap";
import { useSelect } from "../../lib";
import { useCommandValue, getRace } from "../../ducks";

export function StarCommand({ entity }) {
  const race = useSelect(getRace);

  const [shipName, setShipName] = useCommandValue(entity.id, "BuildShip", "");
  const onShipName = useCallback(ev => setShipName(ev.target.value), [
    setShipName,
  ]);

  const [starbaseName, setStarbaseName] = useCommandValue(
    entity.id,
    "BuildStarbase",
    "",
  );
  const onStarbaseName = useCallback(ev => setStarbaseName(ev.target.value), [
    setStarbaseName,
  ]);

  const [satelliteName, setSatelliteName] = useCommandValue(
    entity.id,
    "BuildSatellite",
    "",
  );
  const onSatelliteName = useCallback(ev => setSatelliteName(ev.target.value), [
    setSatelliteName,
  ]);

  const [droids, setDroids] = useCommandValue(entity.id, "BuildDroids", 0);
  const onDroids = useCallback(ev => setDroids(ev.target.value), [setDroids]);

  return (
    <>
      <Card.Body>
        <Form.Group controlId="newShipName">
          <Form.Label>New ship name</Form.Label>
          <Form.Control
            type="text"
            value={shipName}
            onChange={onShipName}
            placeholder="Ships name"
          />
        </Form.Group>
        <Form.Group controlId="newStarbaseName">
          <Form.Label>New starbase name</Form.Label>
          <Form.Control
            type="text"
            value={starbaseName}
            onChange={onStarbaseName}
            placeholder="Starbases name"
          />
        </Form.Group>
        {race === "reptilian" && (
          <Form.Group controlId="newSatelliteName">
            <Form.Label>New satellite name</Form.Label>
            <Form.Control
              value={satelliteName}
              onChange={onSatelliteName}
              placeholder="Satellites name"
            />
          </Form.Group>
        )}
        {race === "droid" && (
          <Form.Group controlId="buildDroids">
            <Form.Label>Build droids</Form.Label>
            <Form.Control
              value={droids}
              onChange={onDroids}
              placeholder="Amount of droids"
            />
          </Form.Group>
        )}
      </Card.Body>
    </>
  );
}
