import React from "react";
import { cx, css } from "emotion";
import Button, { buttonClass } from "./Button";

export const linkButtonClass = cx(
  buttonClass,
  css`
    border: none;
    text-decoration: underline;
    padding: 0;

    :focus,
    :hover {
      border: none;
      color: var(--lightest);
    }
  `
);

function LinkButton({ onClick, children, className = null }) {
  return (
    <Button onClick={onClick} className={cx(linkButtonClass, className)}>
      {children}
    </Button>
  );
}

export default LinkButton;
