import React from "react";
import { Alert as BsAlert } from "react-bootstrap";
import useSelect from "../../../lib/useSelect";
import getAlert from "../selectors/getAlert";
import useDispatch from "../../../lib/useDispatch";
import { deleteAlert } from "../actions/deleteAlert";

function Alert() {
  const alert = useSelect(getAlert);
  const dismiss = useDispatch(deleteAlert);
  if (!alert) return null;

  return (
    <div onClick={dismiss} data-testid="alert-bar">
      <BsAlert onClose={dismiss} dismissible>
        {alert.text}
      </BsAlert>
    </div>
  );
}

export default Alert;
