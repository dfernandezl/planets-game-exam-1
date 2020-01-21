import { DELETE_ALERT, REPLACE_ALERT } from "../";
import { reduceDeleteAlert, reduceReplaceAlert } from "./private";

export function reduceAlert(state = null, action) {
  switch (action.type) {
    case DELETE_ALERT:
      return reduceDeleteAlert(state, action);
    case REPLACE_ALERT:
      return reduceReplaceAlert(state, action);
    default:
      return state;
  }
}
