import { getByTestId } from "@testing-library/dom";
import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/there is something of ([^\s]+) at coordinates _([^_]+)_/i);
  }

  interpretMatch([, playerId, coordinates], _, { container }) {
    const cell = getByTestId(container, coordinates);
    expect(cell).toHaveClass("yours");
  }
}
