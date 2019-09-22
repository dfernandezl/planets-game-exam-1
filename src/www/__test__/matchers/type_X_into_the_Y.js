import userEvent from "@testing-library/user-event";
import { getByLabelText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/type _([^_]+)_ into (the|its) _([^_]+)_/i);
  }

  interpretMatch([, text, the, label], _, { container, wantFor }) {
    const ref = the === "the" ? container : wantFor("it");
    const input = getByLabelText(ref, label, { exact: false });
    userEvent.type(input, text);
  }
}
