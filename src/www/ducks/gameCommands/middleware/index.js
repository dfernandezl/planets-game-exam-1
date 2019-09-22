import { SAVE_COMMANDS } from "../actions/saveCommands";
import { NEXT_PLAYER } from "../actions/nextPlayer";
import { COMPILE_GAME } from "../actions/compileGame";
import whenCompileGame from "./whenCompileGame";
import whenNextPlayer from "./whenNextPlayer";
import whenSaveCommands from "./whenSaveCommands";

export default store => next => action => {
  next(action);

  switch (action.type) {
    case COMPILE_GAME:
      return whenCompileGame(store, action);
    case NEXT_PLAYER:
      return whenNextPlayer(store, action);
    case SAVE_COMMANDS:
      return whenSaveCommands(store, action);
    default: // nothing
  }
};
