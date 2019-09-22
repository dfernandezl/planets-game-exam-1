import { queryByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";
import convertHumanIdIntoTestId from "./helpers/convertHumanIdIntoTestId";

export default class extends AbstractMatcher {
  constructor() {
    super(/it has no _([^_]+)_/i);
  }

  interpretMatch([, humanId], _, { wantFor }) {
    const it = wantFor("it");
    const testId = convertHumanIdIntoTestId(humanId);
    const element = queryByTestId(it, testId);
    expect(element).not.toBeInTheDocument();
  }
}
