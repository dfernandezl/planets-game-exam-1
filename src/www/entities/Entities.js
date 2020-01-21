import React from "react";
import { descriptors, Entity } from "./";

export function Entities({ entities }) {
  return (
    <>
      {descriptors.flatMap(descriptor =>
        entities
          .filter(e => e.type === descriptor.type)
          .map(entity => <Entity entity={entity} key={entity.id} />),
      )}
    </>
  );
}
