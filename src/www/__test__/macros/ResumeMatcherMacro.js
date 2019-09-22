import AbstractRegExpMacro from "./AbstractRegExpMacro";

export default class ResumeMatcherMacro extends AbstractRegExpMacro {
  constructor() {
    super(/\s+<!--\s+RESUME\s+MATCHER\s+-+->/);
  }

  async interpretMatch(match, instruction, { set }) {
    set("matcherPaused", false);
  }
}
