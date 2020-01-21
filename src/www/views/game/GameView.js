import React from "react";
import { Button, Container } from "react-bootstrap";
import { useDispatch, useSelect } from "../../lib";
import {
  getPlayerId,
  saveCommands,
  logoutGame,
  compileGame,
} from "../../ducks";

export function GameView() {
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
