import { findByTestId } from "@testing-library/dom";
import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/the current player is _([^_]+)_/i);
  }

  async interpretMatch([, playerId], _, { container }) {
    const elem = await findByTestId(container, "current-playerId");
    expect(elem).toHaveTextContent(playerId);
  }
}
