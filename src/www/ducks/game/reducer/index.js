import { REPLACE_GAME } from "../actions/replaceGame";
import reduceReplaceGame from "./reduceReplaceGame";
import { LOGOUT_GAME } from "../actions/logoutGame";
import reduceLogoutGame from "./reduceLogoutGame";

export default function reduceGame(state = null, action) {
  switch (action.type) {
    case LOGOUT_GAME:
      return reduceLogoutGame(state, action);
    case REPLACE_GAME:
      return reduceReplaceGame(state, action);
    default:
      return state;
  }
}
