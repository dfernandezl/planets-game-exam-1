import { findByTestId } from "@testing-library/dom";
import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/it is the turn number _([^_]+)_/i);
  }

  async interpretMatch([, turnNumber], _, { container }) {
    const elem = await findByTestId(container, "current-turnNumber");
    expect(elem).toHaveTextContent(turnNumber);
  }
}
