import chalk from "chalk";

export default class InstructionSequence {
  constructor(instructions) {
    this._instructions = instructions;
    this._currentIndex = 0;
  }

  getInstructions() {
    return this._instructions;
  }

  hasNext() {
    return this._currentIndex < this._instructions.length;
  }

  next() {
    const currentInstruction = this._instructions[this._currentIndex];
    this._currentIndex += 1;
    return currentInstruction;
  }

  toString() {
    const instructions = this._instructions;
    const count = instructions.length;
    const previousIndex = this._currentIndex - 1;
    const result = [];

    let index = 0;
    while (index < previousIndex && index < count) {
      result.push(`  ${this._format(index, instructions, chalk.green.dim)}`);
      index += 1;
    }

    if (index < count) {
      result.push(`> ${this._format(index, instructions, chalk.red.bold)}`);
      index += 1;
    } else {
      result.push(`> EOS`);
    }

    while (index < count) {
      result.push(`  ${this._format(index, instructions, chalk.yellow.dim)}`);
      index += 1;
    }

    return result.join("\n");
  }

  _format(index, instructions, color = x => x) {
    const { line, source } = instructions[index];
    return color(`${`    ${line}`.slice(-5)}: ${source}`);
  }
}
