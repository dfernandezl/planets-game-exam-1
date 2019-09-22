import React from "react";
import { Button, Container } from "react-bootstrap";
import useSelect from "../../lib/useSelect";
import getPlayerId from "../../ducks/game/selectors/getPlayerId";
import useDispatch from "../../lib/useDispatch";
import { saveCommands } from "../../ducks/gameCommands/actions/saveCommands";
import logoutGame from "../../ducks/game/actions/logoutGame";
import compileGame from "../../ducks/gameCommands/actions/compileGame";

export default function GameView() {
  const playerId = useSelect(getPlayerId);
  const onSave = useDispatch(saveCommands);
  const onCompile = useDispatch(compileGame);
  const onLogout = useDispatch(logoutGame);

  if (!playerId) return "There is no game loaded";
  return (
    <Container>
      <Button onClick={onSave}>Save game</Button>
      <Button onClick={onCompile}>Compile game</Button>
      <Button onClick={onLogout}>Logout</Button>
    </Container>
  );
}
