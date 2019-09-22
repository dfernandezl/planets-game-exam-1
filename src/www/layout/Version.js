import React from "react";
import { css } from "emotion";
import pkg from "../../../package.json";

const versionClass = css`
  position: absolute;
  top: 0;
  right: 0;
  color: gray;
  font-size: 85%;
  z-index: 1000;
`;

function Version() {
  return (
    <div className={versionClass}>
      {pkg.name} (v{pkg.version})
    </div>
  );
}

export default Version;
