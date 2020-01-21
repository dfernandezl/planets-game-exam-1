import { StarCommand, StarDescription } from "./private";

const priority = 1;
const type = "star";

export const starDescriptor = {
  priority,
  type,
  Command: StarCommand,
  Description: StarDescription,
};
