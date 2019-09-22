import AllMacro from "../macros/AllMacro";

export default class TestInterpreter {
  constructor(context) {
    this._context = context;
    this._allMacro = new AllMacro();
  }

  async interpretTest(instructionSequence) {
    while (instructionSequence.hasNext()) {
      const instruction = instructionSequence.next();
      await instruction.interpret(instruction, this._context);
    }
  }
}
