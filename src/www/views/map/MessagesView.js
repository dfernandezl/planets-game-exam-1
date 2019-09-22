import React, { useMemo } from "react";
import { ListGroup } from "react-bootstrap";
import useSelect from "../../lib/useSelect";
import useDispatch from "../../lib/useDispatch";
import getMessages from "../../ducks/game/selectors/getMessages";
import { setView } from "../../ducks/view/actions/setView";

function Message({ message }) {
  const { coordinates, text } = message;
  const go = useDispatch(setView, { coordinates });

  return <ListGroup.Item onClick={go}>{text}</ListGroup.Item>;
}

export default function MessagesView() {
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
