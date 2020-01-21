import { reduceBlog } from "./reducer";
import { blogMiddleware } from "./middleware";

export * from "./actions";
export * from "./selectors";

export const blogDuck = { default: reduceBlog, middleware: blogMiddleware };
