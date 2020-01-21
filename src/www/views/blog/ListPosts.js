import React, { useEffect } from "react";
import { Container, Breadcrumb } from "react-bootstrap";
import { useDispatch, useSelect } from "../../lib";
import { listPosts, Link, fetchPostList, setView } from "../../ducks";

export function ListPosts() {
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
