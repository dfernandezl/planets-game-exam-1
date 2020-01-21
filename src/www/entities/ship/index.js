import { ShipCommand, ShipDescription } from "./private";

const priority = 5;
const type = "ship";

export const shipDescriptor = {
  priority,
  type,
  Command: ShipCommand,
  Description: ShipDescription,
};
