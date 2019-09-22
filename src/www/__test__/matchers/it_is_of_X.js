import { getByTestId } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/it is of _([^_]+)_/i);
  }

  interpretMatch([, playerId], _, { wantFor }) {
    const it = wantFor("it");
    const element = getByTestId(it, "owner");
    expect(element).toHaveTextContent(playerId);
  }
}
