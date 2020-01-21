import { AbstractRegExpMacro } from "./";

export class TitleMacro extends AbstractRegExpMacro {
  constructor() {
    super(/^###+\s/);
  }

  async interpretMatch(match, { source }, { set }) {
    set("currentTitle", source);
  }
}
