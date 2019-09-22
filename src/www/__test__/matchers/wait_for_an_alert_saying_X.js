import { findByTestId, getByText } from "@testing-library/dom";
import AbstractMatcher from "./AbstractMatcher";
import convertTextToInsensitiveRegExp from "./helpers/convertTextToInsensitiveRegExp";

export default class extends AbstractMatcher {
  constructor() {
    super(/wait for an alert saying _([^_]+)_/i);
  }

  async interpretMatch([, text], _, { container }) {
    const content = convertTextToInsensitiveRegExp(text);
    const alert = await findByTestId(container, "alert-bar");
    expect(alert).toHaveTextContent(content);

    const dismiss = getByText(alert, "Close alert");
    dismiss.click();
  }
}
