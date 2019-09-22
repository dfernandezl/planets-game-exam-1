import SkipTurns from "./SkipTurns";
import LinkMacro from "./LinkMacro";
import PauseMatcherMacro from "./PauseMatcherMacro";
import ResumeMatcherMacro from "./ResumeMatcherMacro";
import MatcherMacro from "./MatcherMacro";
import TitleMacro from "./TitleMacro";
import SnapshotMacro from "./SnapshotMacro";

const macros = [
  SkipTurns,
  LinkMacro,
  TitleMacro,
  PauseMatcherMacro,
  ResumeMatcherMacro,
  SnapshotMacro,
  MatcherMacro,
].map(Macro => new Macro());

export default class AllMacro {
  decodeInstructions(instruction, decodeContent) {
    for (var macro of macros) {
      var instructions = macro.decodeInstructions(instruction, decodeContent);
      if (instructions != null) return instructions;
    }
    return [];
  }
}
