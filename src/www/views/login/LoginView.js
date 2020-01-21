import React, { useCallback, useState } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useDispatch } from "../../lib";
import { loginGame } from "../../ducks";

export function LoginView() {
  const [playerId, setPlayerId] = useState("");
  const onPlayerId = useCallback(ev => setPlayerId(ev.target.value), [
    setPlayerId,
  ]);

  const dispatchLogin = useDispatch(loginGame);
  const onSubmit = useCallback(
    ev => {
      dispatchLogin(playerId);
      ev.preventDefault();
    },
    [dispatchLogin, playerId],
  );

  return (
    <Container>
      <br />
      <br />
      <h1>Log in to play</h1>
      <br />
      <Row>
        <Col md={4}>
          <Form onSubmit={onSubmit}>
            <Form.Group controlId="username">
              <Form.Label>Username</Form.Label>
              <Form.Control
                type="text"
                value={playerId}
                onChange={onPlayerId}
                placeholder="Enter username"
              />
            </Form.Group>
            <Button variant="primary" type="submit">
              Log in
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
}
