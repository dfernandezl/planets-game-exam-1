import escapeStringRegexp from "escape-string-regexp";
import readResource from "../interpreter/readResource";

const LINK = /\[[^\]]*\]\(\?root=Blog&postId=([^&#]+)(&[^#]+)?#(.+)\)/;

function isSection(line, section) {
  if (!section) return line.startsWith("### ");

  const currentSection = line
    .slice(4)
    .toLowerCase()
    .trim()
    .replace(/ /g, "-");
  return isSection(line) && currentSection === section;
}

function findSection(body, section) {
  let result = "";

  const lines = body.split("\n");
  let current = 0;
  while (current < lines.length && !isSection(lines[current], section))
    current += 1;
  current += 1;
  while (current < lines.length && !isSection(lines[current])) {
    result += lines[current] + "\n";
    current += 1;
  }

  return result.toString();
}

function replaceWithReplacements(content, replacements) {
  if (!replacements) return content;
  replacements
    .slice(1)
    .split("&")
    .forEach(replacement => {
      var [symbol, value] = replacement.split("=");
      content = content.replace(
        new RegExp(escapeStringRegexp(symbol), "g"),
        value,
      );
    });
  return content;
}

export default class LinkMacro {
  constructor(regExp) {
    this._regExp = regExp;
  }

  decodeInstructions(instruction, decodeContent) {
    var match = instruction.source.match(LINK);
    if (!match) return null;

    const [, postId, replacements, section] = match;

    const body = readResource("blog", `${postId}.md`);
    let content = findSection(body, section);
    content = replaceWithReplacements(content, replacements);

    const pre = `${instruction.line}:${postId}#${section}:`;
    const instructions = decodeContent(pre, 1, content);
    return instructions;
  }

  filterInstruction({ source }) {
    return LINK.test(source);
  }
}
