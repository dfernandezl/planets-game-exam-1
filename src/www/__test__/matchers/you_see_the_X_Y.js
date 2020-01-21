import { getByTestId } from "@testing-library/dom";
import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/you see the _([^_]+)_ _([^_]+)_/i);
  }

  interpretMatch([, type, name], _, { container, set }) {
    const it = getByTestId(container, `${type}-${name}`);
    const nameWrapper = getByTestId(it, "name");
    expect(nameWrapper).toHaveTextContent(name);
    set("it", it);
  }
}
