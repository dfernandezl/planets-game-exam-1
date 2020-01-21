import { queryByLabelText } from "@testing-library/dom";
import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/you cannot type into (the|its) _([^_]+)_/i);
  }

  interpretMatch([, the, label], _, { container, wantFor }) {
    const ref = the === "the" ? container : wantFor("it");
    const input = queryByLabelText(ref, label, { exact: false });
    expect(input).not.toBeInTheDocument();
  }
}
