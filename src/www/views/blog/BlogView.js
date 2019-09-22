import React from "react";
import useSelect from "../../lib/useSelect";
import getView from "../../ducks/view/selectors/getView";
import ShowPost from "./ShowPost";
import ListPosts from "./ListPosts";

function BlogView() {
  const postId = useSelect(getView, "postId");
  if (postId) return <ShowPost postId={postId} />;
  return <ListPosts />;
}

export default BlogView;
