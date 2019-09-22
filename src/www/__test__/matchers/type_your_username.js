import userEvent from "@testing-library/user-event";
import { getByLabelText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";

export default class extends AbstractMatcher {
  constructor() {
    super(/type your username/i);
  }

  interpretMatch(_a, _b, { container }) {
    const input = getByLabelText(container, "username", { exact: false });
    userEvent.type(input, "yours");
  }
}
