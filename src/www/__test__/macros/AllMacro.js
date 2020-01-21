import {
  SkipTurns,
  LinkMacro,
  PauseMatcherMacro,
  ResumeMatcherMacro,
  MatcherMacro,
  TitleMacro,
  SnapshotMacro,
} from "./";

export class AllMacro {
  constructor() {
    this._macros = [
      SkipTurns,
      LinkMacro,
      TitleMacro,
      PauseMatcherMacro,
      ResumeMatcherMacro,
      SnapshotMacro,
      MatcherMacro,
    ].map(Macro => new Macro());
  }

  decodeInstructions(instruction, decodeContent) {
    for (var macro of this._macros) {
      var instructions = macro.decodeInstructions(instruction, decodeContent);
      if (instructions != null) return instructions;
    }
    return [];
  }
}
