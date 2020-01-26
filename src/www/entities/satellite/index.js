import { SatelliteCommand, SatelliteDescription } from "./private";

const priority = 5;
const type = "satellite";

export const shipDescriptor = {
  priority,
  type,
  Command: SatelliteCommand,
  Description: SatelliteDescription,
};
