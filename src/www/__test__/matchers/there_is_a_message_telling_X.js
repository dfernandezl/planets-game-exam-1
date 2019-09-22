import { getByTestId, getByText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/there is a message telling _([^_]+)_/i);
  }

  interpretMatch([, text], _, { container, set }) {
    const messages = getByTestId(container, "messages");
    const message = getByText(messages, text);
    set("thatMessage", message);
  }
}
