import React, { useEffect } from "react";
import { Container, Breadcrumb, Card, Button } from "react-bootstrap";
import ReactMarkdown from "react-markdown";
import { css } from "emotion";
import { useDispatch, useSelect } from "../../lib";
import { getPost, setView, fetchPost } from "../../ducks";

const postClassName = css`
  background: #ddd;
  color: rgba(0, 0, 0, 0.8);
  padding: 1.5rem;
  background: linear-gradient(
    45deg,
    rgba(242, 246, 248, 1) 0%,
    rgba(216, 225, 231, 1) 50%,
    rgba(181, 198, 208, 1) 51%,
    rgba(224, 239, 249, 1) 100%
  );

  p {
    max-width: 30rem;
  }
  h1 {
    font-size: 5rem;
    color: #000;
  }
  h1 + p {
    font-size: 2rem;
    color: rgba(0, 0, 0, 0.5);
    max-width: none;
    line-height: 1.1;
    font-weight: 300;
  }
  h2 {
    font-size: 3rem;
    margin-top: 3rem;
    border-bottom: solid 0.1em rgba(0, 0, 0, 0.8);
    text-transform: uppercase;
  }
  h3 {
    font-size: 2rem;
    margin-top: 2rem;
  }
  blockquote {
    background: black;
    background: linear-gradient(
      45deg,
      rgba(76, 76, 76, 1) 0%,
      rgba(89, 89, 89, 1) 12%,
      rgba(102, 102, 102, 1) 25%,
      rgba(71, 71, 71, 1) 39%,
      rgba(44, 44, 44, 1) 50%,
      rgba(0, 0, 0, 1) 51%,
      rgba(17, 17, 17, 1) 60%,
      rgba(43, 43, 43, 1) 76%,
      rgba(28, 28, 28, 1) 91%,
      rgba(19, 19, 19, 1) 100%
    );
    border-radius: 0.25rem;
    color: rgba(255, 255, 255, 0.8);
    border: none;
    padding: 0.75rem 1.5rem;
    max-width: 33rem;
  }
  blockquote p:last-child {
    margin-bottom: 0;
  }
`;

export function ShowPost({ postId }) {
  const post = useSelect(getPost, { postId });
  const goHome = useDispatch(setView, { root: "Home" });
  const goBlog = useDispatch(setView, { postId: null });
  const refresh = useDispatch(fetchPost, postId);
  useEffect(refresh, []);

  const backToPosts = (
    <Button variant="link" onClick={goBlog}>
      « Back to posts
    </Button>
  );

  return (
    <Container>
      <br />
      <Breadcrumb>
        <Breadcrumb.Item onClick={goHome}>Home</Breadcrumb.Item>
        <Breadcrumb.Item onClick={goBlog}>Blog</Breadcrumb.Item>
        <Breadcrumb.Item active>{post.title}</Breadcrumb.Item>
      </Breadcrumb>
      <Card body bg="light" className={postClassName}>
        <ReactMarkdown source={post.body} escapeHtml={false} />
      </Card>
      {backToPosts}
    </Container>
  );
}
