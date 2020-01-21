import React, { useMemo } from "react";
import { ListGroup } from "react-bootstrap";
import { useDispatch, useSelect } from "../../lib";
import { setView, getMessages } from "../../ducks";

function Message({ message }) {
  const { coordinates, text } = message;
  const go = useDispatch(setView, { coordinates });

  return <ListGroup.Item onClick={go}>{text}</ListGroup.Item>;
}

export function MessagesView() {
  const messages = useSelect(getMessages);

  return useMemo(
    () => (
      <ListGroup data-testid="messages">
        {messages.map((message, index) => (
          <Message key={index} message={message} />
        ))}
      </ListGroup>
    ),
    [messages],
  );
}
