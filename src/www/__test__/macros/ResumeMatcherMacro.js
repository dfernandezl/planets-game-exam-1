import { AbstractRegExpMacro } from "./";

export class ResumeMatcherMacro extends AbstractRegExpMacro {
  constructor() {
    super(/\s+<!--\s+RESUME\s+MATCHER\s+-+->/);
  }

  async interpretMatch(match, instruction, { set }) {
    set("matcherPaused", false);
  }
}
