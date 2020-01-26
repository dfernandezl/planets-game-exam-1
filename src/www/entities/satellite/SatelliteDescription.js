import React from "react";
import { Card } from "react-bootstrap";

export function SatelliteDescription({ entity }) {
  const { name, level } = entity;

  return (
    <>
      <Card.Header data-testid="name" className="bg-primary">
        s Satellite: <span>{name}</span>
      </Card.Header>
      <Card.Body>
        {level != null && (
          <div>
            <strong>Level</strong>:{" "}
            <span data-testid="level">{level}</span>
          </div>
        )}
      </Card.Body>
    </>
  );
}
