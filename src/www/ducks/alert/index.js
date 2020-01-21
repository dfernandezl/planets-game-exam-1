import { reduceAlert } from "./reducer";

export * from "./actions";
export * from "./components";
export * from "./selectors";

export const alertDuck = { default: reduceAlert };
