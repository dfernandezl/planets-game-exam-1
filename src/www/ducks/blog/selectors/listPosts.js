import { createSelector } from "reselect";
import getBlog from "./getBlog";

function compareIds(a, b) {
  if (a.id < b.id) return +1;
  if (a.id > b.id) return -1;
  return 0;
}

function makeListPosts() {
  return createSelector(
    getBlog,
    blog => Object.values(blog).sort(compareIds),
  );
}

const listPosts = makeListPosts();
export default listPosts;
