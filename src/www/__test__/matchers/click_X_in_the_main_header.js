import { getByTestId, getByText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/click _([^_]+)_ in the main header/i);
  }

  interpretMatch([, linkText], _, { container }) {
    const header = getByTestId(container, "header");
    const link = getByText(header, linkText);
    link.click();
  }
}
