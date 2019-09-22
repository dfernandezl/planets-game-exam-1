import React from "react";
import { Card } from "react-bootstrap";

export default function StarbaseDescription({ entity }) {
  const { name, playerId, fuel, maxFuel } = entity;

  return (
    <>
      <Card.Header data-testid="name" className="bg-success">
        ⌔ Starbase: <span>{name}</span>
      </Card.Header>
      <Card.Body>
        {playerId && (
          <div data-testid="owner">
            <strong>Owner</strong>: {playerId}.
          </div>
        )}
        {fuel != null && (
          <div>
            <strong>Fuel</strong>: <span data-testid="fuel">{fuel}</span>/
            <span data-testid="total-fuel-capacity">{maxFuel}</span>
          </div>
        )}
      </Card.Body>
    </>
  );
}
