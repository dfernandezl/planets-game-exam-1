import { StarbaseCommand } from "./StarbaseCommand";
import { StarbaseDescription } from "./StarbaseDescription";

const priority = 1;
const type = "starbase";

export const starbaseDescriptor = {
  priority,
  type,
  Command: StarbaseCommand,
  Description: StarbaseDescription,
};
