import { AbstractMatcher } from "./";

export default class extends AbstractMatcher {
  constructor() {
    super(/click that message/i);
  }

  interpretMatch([,], _, { thatMessage }) {
    thatMessage.click();
  }
}
