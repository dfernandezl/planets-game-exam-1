import React from "react";
import { Container, Button } from "react-bootstrap";
import { useDispatch, useSelect } from "../../lib";
import {
  getPlayerId,
  getRace,
  getTurnNumber,
  nextPlayer,
  compileGame,
} from "../../ducks";

export function MapStatsView() {
  const playerId = useSelect(getPlayerId);
  const race = useSelect(getRace);
  const turnNumber = useSelect(getTurnNumber);
  const onNext = useDispatch(nextPlayer);
  const onCompile = useDispatch(compileGame);

  return (
    <Container>
      <Button onClick={onNext}>Next</Button>
      {" | "}
      <Button onClick={onCompile}>Compile</Button>
      {" | "}
      Turn: <span data-testid="current-turnNumber">{turnNumber}</span>
      {" | "}
      Player: <span data-testid="current-playerId">{playerId}</span>
      {" | "}
      Race: <span data-testid="current-race">{race}</span>
    </Container>
  );
}
