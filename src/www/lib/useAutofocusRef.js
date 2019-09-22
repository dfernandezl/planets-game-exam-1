import { useCallback } from "react";
import ReactDOM from "react-dom";

function useAutofocusRef(autofocus) {
  let focusFn = autofocus
    ? c => (ReactDOM.findDOMNode(c) || { focus: () => {} }).focus()
    : () => {};

  return useCallback(focusFn, [autofocus]);
}

export default useAutofocusRef;
