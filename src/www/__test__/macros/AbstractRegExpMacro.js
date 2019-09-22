export default class AbstractRegExpMacro {
  constructor(regExp) {
    this._regExp = regExp;
  }

  decodeInstructions(instruction) {
    if (!this.filterInstruction(instruction)) {
      return null;
    }
    return [
      {
        ...instruction,
        interpret: this.interpretInstruction,
      },
    ];
  }

  filterInstruction({ source }) {
    return this._regExp.test(source);
  }

  interpretInstruction = async (instruction, context) => {
    const { source } = instruction;
    const match = source.match(this._regExp);
    if (!match) return false;

    await this.interpretMatch(match, instruction, context);
  };

  async interpretMatch(match, instruction, context) {
    throw new Error(
      `Unimplemented method ${this.constructor.name}.interpretMatch(…)`,
    );
  }
}
