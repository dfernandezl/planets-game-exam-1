import { getByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";
import convertHumanIdIntoTestId from "./helpers/convertHumanIdIntoTestId";

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
