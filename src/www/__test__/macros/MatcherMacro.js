import AllMatchers from "../matchers/AllMatchers";
import AbstractRegExpMacro from "./AbstractRegExpMacro";

export default class MatcherMacro extends AbstractRegExpMacro {
  constructor() {
    super(/^[\s>]+[^\s>]/);

    this._allMatchers = new AllMatchers();
  }

  async interpretMatch(match, instruction, context) {
    if (context.matcherPaused) return;

    await this._allMatchers.interpretInstruction(instruction, context);
  }
}
