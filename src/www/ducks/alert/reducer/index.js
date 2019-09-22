import { DELETE_ALERT } from "../actions/deleteAlert";
import reduceDeleteAlert from "./reduceDeleteAlert";
import { REPLACE_ALERT } from "../actions/replaceAlert";
import reduceReplaceAlert from "./reduceReplaceAlert";

function reduceAlert(state = null, action) {
  switch (action.type) {
    case DELETE_ALERT:
      return reduceDeleteAlert(state, action);
    case REPLACE_ALERT:
      return reduceReplaceAlert(state, action);
    default:
      return state;
  }
}

export default reduceAlert;
