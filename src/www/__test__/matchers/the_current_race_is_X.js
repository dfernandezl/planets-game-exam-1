import { findByTestId } from "@testing-library/dom";
import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/the current race is _([^_]+)_/i);
  }

  async interpretMatch([, race], _, { container }) {
    const elem = await findByTestId(container, "current-race");
    expect(elem).toHaveTextContent(race);
  }
}
