import AbstractRegExpMacro from "./AbstractRegExpMacro";

export default class TitleMacro extends AbstractRegExpMacro {
  constructor() {
    super(/^###+\s/);
  }

  async interpretMatch(match, { source }, { set }) {
    set("currentTitle", source);
  }
}
