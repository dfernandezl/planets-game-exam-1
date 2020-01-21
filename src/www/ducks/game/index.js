import { reduceGame } from "./reducer";
import { gameMiddleware } from "./middleware";

export * from "./actions";
export * from "./selectors";

export const gameDuck = { default: reduceGame, middleware: gameMiddleware };
