import AllMacro from "../macros/AllMacro";

let allMacro = new AllMacro();

export default function decodeContent(pre, firstLineNumber, content) {
  const lines = content.split("\n");
  const instructions = lines.map((source, index) => ({
    line: pre + (firstLineNumber + index),
    source,
  }));
  const decodedInstructions = instructions.flatMap(i =>
    allMacro.decodeInstructions(i, decodeContent),
  );

  return decodedInstructions;
}
