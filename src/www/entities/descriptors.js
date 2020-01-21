import { starDescriptor as star } from "./star";
import { shipDescriptor as ship } from "./ship";
import { starbaseDescriptor as starbase } from "./starbase";
import { indexBy } from "../lib";

const descriptors = [
  star,
  ship,
  starbase,
  //
].sort((a, b) => a.priority - b.priority);

const descriptorsByType = indexBy(descriptors, "type");

function getDescriptor(entity) {
  return descriptorsByType[entity.type];
}

export { descriptors, descriptorsByType, getDescriptor };
