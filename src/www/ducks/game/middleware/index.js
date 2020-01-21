import { FETCH_GAME, LOGIN_GAME, NEW_GAME } from "../actions";
import { whenFetchGame, whenLoginGame, whenNewGame } from "./private";

export const gameMiddleware = store => next => action => {
  next(action);

  switch (action.type) {
    case FETCH_GAME:
      return whenFetchGame(store, action);
    case LOGIN_GAME:
      return whenLoginGame(store, action);
    case NEW_GAME:
      return whenNewGame(store, action);
    default: // nothing
  }
};
