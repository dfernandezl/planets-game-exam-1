import { starDescriptor as star } from "./star";
import { shipDescriptor as ship } from "./ship";
import { starbaseDescriptor as starbase } from "./starbase";
//import { satelliteDescriptor as satellite } from "./satellite";
import * as satellite from "./satellite/index";
import { indexBy } from "../lib";

const descriptors = [
  star,
  ship,
  starbase,
  satellite,
  //
].sort((a, b) => a.priority - b.priority);

const descriptorsByType = indexBy(descriptors, "type");

function getDescriptor(entity) {
  return descriptorsByType[entity.type];
}

export { descriptors, descriptorsByType, getDescriptor };
