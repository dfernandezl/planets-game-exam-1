import { REPLACE_GAME } from "../../game/actions/replaceGame";
import reduceReplaceGame from "./reduceReplaceGame";
import { SET_COMMAND } from "../actions/setCommand";
import reduceSetCommand from "./reduceSetCommand";

export default function reduceGameCommands(state = {}, action) {
  switch (action.type) {
    case REPLACE_GAME:
      return reduceReplaceGame(state, action);
    case SET_COMMAND:
      return reduceSetCommand(state, action);
    default:
      return state;
  }
}
