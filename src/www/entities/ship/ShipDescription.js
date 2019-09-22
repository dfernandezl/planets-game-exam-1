import React from "react";
import { Card } from "react-bootstrap";

export default function ShipDescription({ entity }) {
  const { name, population, maxPopulation, fuel, maxFuel } = entity;

  return (
    <>
      <Card.Header data-testid="name" className="bg-primary">
        ▶ Ship: <span>{name}</span>
      </Card.Header>
      <Card.Body>
        {population != null && (
          <div>
            <strong>Population</strong>:{" "}
            <span data-testid="population">{population}</span>/
            <span data-testid="maximum-population">{maxPopulation}</span>
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
