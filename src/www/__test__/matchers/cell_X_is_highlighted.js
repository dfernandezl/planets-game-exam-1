import { getByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/cell _([^_]+)_ is highlighted/i);
  }

  interpretMatch([, coordinates], _, { container }) {
    const cell = getByTestId(container, coordinates);
    expect(cell).toHaveClass("highlighted");
  }
}
