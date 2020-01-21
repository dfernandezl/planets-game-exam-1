import { queryByTestId, queryByText } from "@testing-library/dom";
import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/there is no message telling _([^_]+)_/i);
  }

  interpretMatch([, text], _, { container, set }) {
    const messages = queryByTestId(container, "messages");
    const message = messages && queryByText(messages, text);
    expect(message).not.toBeInTheDocument();
  }
}
