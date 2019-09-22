import { queryByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/you see no _([^_]+)s_/i);
  }

  interpretMatch([, type, name], _, { container, set }) {
    const it = queryByTestId(container, `${type}-${name}`);
    expect(it).not.toBeInTheDocument();
  }
}
