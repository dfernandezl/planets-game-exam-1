import React from "react";
import { Container, Navbar, Nav } from "react-bootstrap";

import { useDispatch, useSelect } from "../lib";
import { setView, hasPlayer } from "../ducks";

export function Header() {
  const goHome = useDispatch(setView, { root: "Home" });
  const goPlay = useDispatch(setView, { root: "Play" });
  const goNew = useDispatch(setView, { root: "New" });
  const goBlog = useDispatch(setView, { root: "Blog" });
  const logged = useSelect(hasPlayer);
  const goGame = useDispatch(setView, { root: "Game" });

  return (
    <Navbar bg="light" expand="lg" data-testid="header">
      <Container>
        <Navbar.Brand onClick={goHome}>●▶ PLANETS GAME</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link onClick={goHome}>Home</Nav.Link>
            <Nav.Link onClick={goPlay}>Play</Nav.Link>
            {logged && <Nav.Link onClick={goGame}>Game</Nav.Link>}
            <Nav.Link onClick={goNew}>New</Nav.Link>
            <Nav.Link onClick={goBlog}>Blog</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;
