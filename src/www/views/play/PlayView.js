import React from "react";
import { Row, Col } from "react-bootstrap";
import { useSelect } from "../../lib";
import { hasPlayer, getView } from "../../ducks";
import { LoginView, CellView, MapView, MessagesView, MapStatsView } from "../";

export function PlayView() {
  const logged = useSelect(hasPlayer);
  const coordinates = useSelect(getView, "coordinates");

  if (!logged) return <LoginView />;
  return (
    <>
      <MapStatsView />
      <Row>
        <Col>
          <MapView />
        </Col>
        <Col>
          {!coordinates && <MessagesView />}
          {coordinates && <CellView />}
        </Col>
      </Row>
    </>
  );
}
