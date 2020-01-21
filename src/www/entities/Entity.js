import React from "react";
import { Card } from "react-bootstrap";
import { useSelect } from "../lib";
import { getPlayerId } from "../ducks";
import { getDescriptor } from "./";

export function Entity({ entity }) {
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
