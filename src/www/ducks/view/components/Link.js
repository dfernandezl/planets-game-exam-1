import React from "react";
import { css, cx } from "emotion";
import { useDispatch } from "../../../lib";
import { setView } from "../actions/setView";

const linkClass = css`
  cursor: pointer;
  text-decoration: underline;
  :hover {
    color: var(--lightest);
  }
`;

export function Link({ children, view, className = null }) {
  const followLink = useDispatch(setView, view);

  return (
    <span className={cx(linkClass, className)} onClick={followLink}>
      {children}
    </span>
  );
}
