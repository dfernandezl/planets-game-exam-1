import React from "react";
import { Row, Col } from "react-bootstrap";
import LoginView from "../login/LoginView";
import useSelect from "../../lib/useSelect";
import hasPlayer from "../../ducks/game/selectors/hasPlayer";
import MapView from "../map/MapView";
import MessagesView from "../map/MessagesView";
import CellView from "../cell/CellView";
import MapStatsView from "./MapStatsView";
import getView from "../../ducks/view/selectors/getView";

function PlayView() {
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

export default PlayView;
