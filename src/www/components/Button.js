import React from "react";
import { cx, css } from "emotion";

export const buttonClass = css`
  background: transparent;
  font-size: inherit;
  height: 2em;
  box-sizing: border-box;
  border: solid var(--light) 2px;
  color: var(--light);
  padding: 0 1em;
  cursor: pointer;

  :focus,
  :hover {
    outline: none;
    color: var(--light);
    border: solid var(--lightest) 2px;
  }
`;

function Button({ onClick, children, className }) {
  return (
    <button className={cx(buttonClass, className)} onClick={onClick}>
      {children}
    </button>
  );
}

export default Button;
