import React from "react";
import { Card } from "react-bootstrap";

export function StarDescription({ entity }) {
  const {
    name,
    population,
    maxPopulation,
    playerId,
    minerals,
    mineralsReserve,
    populationBoost,
  } = entity;

  return (
    <>
      <Card.Header data-testid="name" className="bg-warning">
        ● Star: <span>{name}</span>
      </Card.Header>
      <Card.Body>
        {playerId && (
          <div data-testid="owner">
            <strong>Owner</strong>: {playerId}.
          </div>
        )}
        {population != null && (
          <div>
            <strong>Population</strong>:{" "}
            <span data-testid="population">{population}</span>/
            <span data-testid="maximum-population">{maxPopulation}</span>
          </div>
        )}
        {minerals != null && (
          <div>
            <strong>Minerals</strong>:{" "}
            <span data-testid="minerals-availability">{minerals}</span>[
            <span data-testid="minerals-reserve">{mineralsReserve}</span>]
          </div>
        )}
        {populationBoost != null && (
          <div>
            <strong>Population boost</strong>:{" "}
            <span data-testid="population-boost">{populationBoost}</span>
          </div>
        )}
      </Card.Body>
    </>
  );
}
