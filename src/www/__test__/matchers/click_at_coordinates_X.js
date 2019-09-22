import { getByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/click at coordinates _([^_]+)_/i);
  }

  interpretMatch([, coordinates], _, { container }) {
    const cell = getByTestId(container, coordinates);
    cell.click();
  }
}
