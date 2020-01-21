import { REPLACE_GAME, LOGOUT_GAME } from "../actions";
import { reduceReplaceGame, reduceLogoutGame } from "./private";

export function reduceGame(state = null, action) {
  switch (action.type) {
    case LOGOUT_GAME:
      return reduceLogoutGame(state, action);
    case REPLACE_GAME:
      return reduceReplaceGame(state, action);
    default:
      return state;
  }
}
