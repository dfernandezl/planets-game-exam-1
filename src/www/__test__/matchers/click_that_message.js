import { getByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/click that message/i);
  }

  interpretMatch([,], _, { thatMessage }) {
    thatMessage.click();
  }
}
