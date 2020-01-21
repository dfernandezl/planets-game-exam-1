import { useCallback } from "react";
import ReactDOM from "react-dom";

export function useAutofocusRef(autofocus) {
  let focusFn = autofocus
    ? c => (ReactDOM.findDOMNode(c) || { focus: () => {} }).focus()
    : () => {};

  return useCallback(focusFn, [autofocus]);
}
