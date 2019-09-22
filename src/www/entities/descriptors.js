import * as star from "./star/index";
import * as ship from "./ship/index";
import * as starbase from "./starbase/index";
import indexBy from "../lib/indexBy";

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

export { descriptors as default, descriptorsByType, getDescriptor };
