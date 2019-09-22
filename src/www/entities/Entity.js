import React from "react";
import { Card } from "react-bootstrap";
import { getDescriptor } from "./descriptors";
import useSelect from "../lib/useSelect";
import getPlayerId from "../ducks/game/selectors/getPlayerId";

export default function Entity({ entity }) {
  const { name, type, playerId } = entity;
  const { Description, Command } = getDescriptor(entity);
  const currentPlayerId = useSelect(getPlayerId);

  return (
    <>
      <Card data-testid={`${type}-${name}`}>
        <Description entity={entity} />
        {playerId === currentPlayerId && <Command entity={entity} />}
      </Card>
      <br />
    </>
  );
}
