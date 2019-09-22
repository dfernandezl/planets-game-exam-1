import userEvent from "@testing-library/user-event";
import { queryByLabelText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

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
