import { useCallback } from "react";
import useDispatch from "./useDispatch";

function useSubmitDispatch(actionCreator, ...args) {
  const dispatch = useDispatch(actionCreator, ...args);
  return useCallback(
    event => {
      event.preventDefault();
      dispatch();
    },
    [dispatch]
  );
}

export default useSubmitDispatch;
