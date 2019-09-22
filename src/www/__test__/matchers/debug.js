import { getByTestId, getByText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/debug/i);
  }

  interpretMatch(_a, _b, context) {
    console.log(context);
    context.debug();
    throw new Error("there is a debug");
  }
}
