import { AbstractRegExpMacro } from "./";

export class PauseMatcherMacro extends AbstractRegExpMacro {
  constructor() {
    super(/\s+<!--\s+PAUSE\s+MATCHER\s+-+->/);
  }

  async interpretMatch(match, instruction, { set }) {
    set("matcherPaused", true);
  }
}
