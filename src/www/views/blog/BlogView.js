import React from "react";
import { useSelect } from "../../lib";
import { getView } from "../../ducks";
import { ListPosts, ShowPost } from "./";

export function BlogView() {
  const postId = useSelect(getView, "postId");
  if (postId) return <ShowPost postId={postId} />;
  return <ListPosts />;
}
