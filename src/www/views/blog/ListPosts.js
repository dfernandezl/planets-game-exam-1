import React, { useEffect } from "react";
import { Container, Breadcrumb } from "react-bootstrap";
import listPosts from "../../ducks/blog/selectors/listPosts";
import Link from "../../ducks/view/components/Link";
import useDispatch from "../../lib/useDispatch";
import { fetchPostList } from "../../ducks/blog/actions/fetchPostList";
import useSelect from "../../lib/useSelect";
import { setView } from "../../ducks/view/actions/setView";

function ListPosts() {
  const list = useSelect(listPosts);
  const goHome = useDispatch(setView, { root: "Home" });
  const refresh = useDispatch(fetchPostList);
  useEffect(refresh, []);

  return (
    <Container>
      <br />
      <Breadcrumb>
        <Breadcrumb.Item onClick={goHome}>Home</Breadcrumb.Item>
        <Breadcrumb.Item active>Blog</Breadcrumb.Item>
      </Breadcrumb>
      <h1>Latest news</h1>
      <ul>
        {list.map(p => (
          <li key={p.id}>
            <Link view={{ postId: p.id }}>{p.title}</Link>
          </li>
        ))}
      </ul>
    </Container>
  );
}

export default ListPosts;
