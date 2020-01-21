import { REPLACE_GAME } from "../../game/actions/replaceGame";
import { whenReplaceGame } from "./private";

export const gameViewMiddleware = store => next => action => {
  next(action);

  switch (action.type) {
    case REPLACE_GAME:
      return whenReplaceGame(store, action);
    default: // do nothing
  }
};
