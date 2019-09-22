import { REPLACE_GAME } from "../../game/actions/replaceGame";
import whenReplaceGame from "./whenReplaceGame";

export default store => next => action => {
  next(action);

  switch (action.type) {
    case REPLACE_GAME:
      return whenReplaceGame(store, action);
    default: // do nothing
  }
};
