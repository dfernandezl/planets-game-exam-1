const SKIP = /\s+.*skip\s+turns\s+from\s+_(\d+)_\s+to\s+_(\d+)_/i;

export default class LinkMacro {
  constructor(regExp) {
    this._regExp = regExp;
  }

  decodeInstructions(instruction, decodeContent) {
    var match = instruction.source.match(SKIP);
    if (!match) return null;

    const start = +match[1];
    const end = +match[2];
    let content = "";
    for (var turn = start + 1; turn <= end; turn += 1) {
      content += ` Click the _Compile_ button\n`;
      content += ` <!-- SNAPSHOT skipping_${start}:${end}_${turn} status=200 -->\n`;
      content += ` It is the turn number _${turn}_\n`;
    }

    const pre = `${instruction.line}:SkipTurnsFrom${start}To${end}:`;
    const instructions = decodeContent(pre, 1, content);
    return instructions;
  }

  filterInstruction({ source }) {
    return SKIP.test(source);
  }
}
