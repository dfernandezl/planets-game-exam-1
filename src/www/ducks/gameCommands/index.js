import { reduceGameCommands } from "./reducer";
import { gameCommandsMiddleware } from "./middleware";

export * from "./actions";
export * from "./hooks";
export * from "./selectors";

export const gameCommandsDuck = {
  default: reduceGameCommands,
  middleware: gameCommandsMiddleware,
};
