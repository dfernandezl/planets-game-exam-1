import { SAVE_COMMANDS, NEXT_PLAYER, COMPILE_GAME } from "../actions";
import { whenCompileGame, whenNextPlayer, whenSaveCommands } from "./private";

export const gameCommandsMiddleware = store => next => action => {
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
