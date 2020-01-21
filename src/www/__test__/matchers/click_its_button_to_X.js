import { getByTestId } from "@testing-library/dom";
import { AbstractMatcher } from "./";
import { convertHumanIdIntoTestId } from "./helpers";

export default class extends AbstractMatcher {
  constructor() {
    super(/click its button to _([^_]+)_/i);
  }

  async interpretMatch([, buttonHumanId], _, { wantFor }) {
    const it = wantFor("it");
    const testId = convertHumanIdIntoTestId(buttonHumanId);
    const button = getByTestId(it, testId);
    button.click();
  }
}
