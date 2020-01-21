import React from "react";
import { Alert as BsAlert } from "react-bootstrap";
import { useDispatch, useSelect } from "../../../lib";
import { getAlert, deleteAlert } from "../";

export function Alert() {
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
