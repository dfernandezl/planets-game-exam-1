import { useCallback } from "react";
import { useDispatch as useDispatchRR } from "react-redux";

function useDispatch(actionCreator, ...args) {
  if (!actionCreator) throw new Error("The actionCreator is not a function");
  const dispatchRR = useDispatchRR();
  const dispatch = useCallback(
    (...moreArgs) => {
      const action = actionCreator(...args, ...moreArgs);
      dispatchRR(action);
    },
    // eslint-disable-next-line react-hooks/exhaustive-deps
    [actionCreator, ...args]
  );
  return dispatch;
}

export default useDispatch;
