import { getByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/there (are|is a) _([^_]+)_ at coordinates _([^_]+)_/i);
  }

  interpretMatch([, , type, coordinates], _, { container }) {
    const cell = getByTestId(container, coordinates);
    getByTestId(cell, type);
  }
}
