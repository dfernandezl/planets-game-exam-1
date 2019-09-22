import React from "react";
import descriptors from "./descriptors";
import Entity from "./Entity";

export default function Entities({ entities }) {
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
