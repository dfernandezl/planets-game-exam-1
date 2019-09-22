import { getByLabelText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";
import convertHumanIdIntoTestId from "./helpers/convertHumanIdIntoTestId";

export default class extends AbstractMatcher {
  constructor() {
    super(/it has _([^_]+)_ typed into the _([^_]+)_/i);
  }

  interpretMatch([, value, label], _, { wantFor }) {
    const it = wantFor("it");
    const input = getByLabelText(it, label, { exact: false });
    expect(input).toHaveValue(value);
  }
}
