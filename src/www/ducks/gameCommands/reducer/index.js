import { REPLACE_GAME } from "../../game";
import { SET_COMMAND } from "../actions";
import { reduceSetCommand, reduceReplaceGame } from "./private";

export function reduceGameCommands(state = {}, action) {
  switch (action.type) {
    case REPLACE_GAME:
      return reduceReplaceGame(state, action);
    case SET_COMMAND:
      return reduceSetCommand(state, action);
    default:
      return state;
  }
}
