import React from "react";
import { Container, Button } from "react-bootstrap";
import useSelect from "../../lib/useSelect";
import getPlayerId from "../../ducks/game/selectors/getPlayerId";
import getRace from "../../ducks/game/selectors/getRace";
import getTurnNumber from "../../ducks/game/selectors/getTurnNumber";
import useDispatch from "../../lib/useDispatch";
import { nextPlayer } from "../../ducks/gameCommands/actions/nextPlayer";
import compileGame from "../../ducks/gameCommands/actions/compileGame";

function MapStatsView() {
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

export default MapStatsView;
