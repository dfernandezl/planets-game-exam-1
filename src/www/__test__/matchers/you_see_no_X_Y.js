import { queryByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/you see no _([^_]+)_ _([^_]+)_/i);
  }

  interpretMatch([, type, name], _, { container }) {
    const it = queryByTestId(container, `${type}-${name}`);
    expect(it).not.toBeInTheDocument();
  }
}
