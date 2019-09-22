import React, { useState, useCallback } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import newGame from "../../ducks/game/actions/newGame";
import useDispatch from "../../lib/useDispatch";

function NewPlayer({ index, setPlayers, players }) {
  const player = players[index];
  const setPlayer = useCallback(
    changes => {
      const copy = [...players];
      copy[index] = { ...players[index], ...changes };
      setPlayers(copy);
    },
    [players, index, setPlayers],
  );
  const onPlayerId = useCallback(
    ev => setPlayer({ playerId: ev.target.value }),
    [setPlayer],
  );
  const onRace = useCallback(ev => setPlayer({ race: ev.target.value }), [
    setPlayer,
  ]);

  const playerN = `player${index + 1}`;
  const raceN = `race${index + 1}`;
  return (
    <Row>
      <Col>
        <Form.Group controlId={playerN}>
          <Form.Label>Player {index + 1}</Form.Label>
          <Form.Control
            type="text"
            value={player.playerId}
            onChange={onPlayerId}
            name={playerN}
            placeholder="Enter the player alias"
          />
        </Form.Group>
      </Col>
      <Col>
        <Form.Group controlId={raceN}>
          <Form.Label>Race {index + 1}</Form.Label>
          <Form.Control
            as="select"
            value={player.race}
            onChange={onRace}
            name={raceN}
          >
            <option>Human</option>
            <option>Reptilian</option>
            <option>Droid</option>
          </Form.Control>
        </Form.Group>
      </Col>
    </Row>
  );
}

export default function NewView() {
  const [mapCode, setMapCode] = useState("");
  const onMapCode = useCallback(ev => setMapCode(ev.target.value), []);

  const [players, setPlayers] = useState([]);
  const addPlayer = useCallback(
    () => setPlayers([...players, { playerId: "", race: "Human" }]),
    [players],
  );

  const dispatchNewGame = useDispatch(newGame);
  const onSubmit = useCallback(
    ev => {
      dispatchNewGame(mapCode, players);
      ev.preventDefault();
    },
    [dispatchNewGame, mapCode, players],
  );

  return (
    <Container>
      <br />
      <br />
      <h1>Create a new universe</h1>
      <br />
      <Row>
        <Col md={4}>
          <Form onSubmit={onSubmit}>
            <Form.Group controlId="mapCode">
              <Form.Label>Map code</Form.Label>
              <Form.Control
                type="text"
                value={mapCode}
                onChange={onMapCode}
                name={mapCode}
                placeholder="Enter the map code"
              />
            </Form.Group>
            {players.map((player, index) => (
              <NewPlayer
                key={index}
                index={index}
                setPlayers={setPlayers}
                players={players}
              />
            ))}
            <Button variant="secondary" onClick={addPlayer}>
              Add player
            </Button>{" "}
            <Button variant="primary" type="submit">
              Create
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
}
