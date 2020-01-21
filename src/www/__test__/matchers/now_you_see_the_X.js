import { findByTestId } from "@testing-library/dom";
import { AbstractMatcher } from "./";
import { convertHumanIdIntoTestId } from "./helpers";

export default class extends AbstractMatcher {
  constructor() {
    super(/now you see the _([^_]+)_/i);
  }

  async interpretMatch([, humanId], _, { container }) {
    const testId = convertHumanIdIntoTestId(humanId);
    await findByTestId(container, testId);
  }
}
