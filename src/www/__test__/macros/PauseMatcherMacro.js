import AbstractRegExpMacro from "./AbstractRegExpMacro";

export default class PauseMatcherMacro extends AbstractRegExpMacro {
  constructor() {
    super(/\s+<!--\s+PAUSE\s+MATCHER\s+-+->/);
  }

  async interpretMatch(match, instruction, { set }) {
    set("matcherPaused", true);
  }
}
