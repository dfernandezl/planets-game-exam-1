import chalk from "chalk";
import Context from "./Context";
import FileTokenizer from "./FileTokenizer";
import TestInterpreter from "./TestInterpreter";
import InstructionSequence from "./InstructionSequence";
import decodeContent from "../macros/decodeContent";

export default class FileInterpreter {
  _befores = [];
  _afters = [];
  _rootContext = new Context();

  afterTest(fn) {
    this._afters.push(fn);
    return this;
  }

  beforeTest(fn) {
    this._befores.push(fn);
    return this;
  }

  configure(fn) {
    fn(this._rootContext);
    return this;
  }

  interpretFile(file) {
    const fileTokenizer = new FileTokenizer(file);

    try {
      this._interpretFile(fileTokenizer);
    } catch (e) {
      console.error(`Error at:\n${fileTokenizer.toString()}`);
      throw e;
    }
  }

  _skipUntilTest(fileTokenizer) {
    fileTokenizer.skipUntil(/^##[^#]/i);
  }

  _interpretFile(fileTokenizer) {
    this._skipUntilTest(fileTokenizer);
    while (!fileTokenizer.eof()) {
      this._interpretTest(fileTokenizer);
    }
  }

  _interpretTest(fileTokenizer) {
    const title = fileTokenizer.accept();
    const lineNumber = fileTokenizer.getLineNumber();
    const content = fileTokenizer.acceptUntil(/^##[^#]/).join("\n");

    const testContext = this._rootContext.clone();
    const testInterpreter = new TestInterpreter(testContext);
    const instructions = decodeContent("", lineNumber, content);
    const instructionSequence = new InstructionSequence(instructions);

    test(title, async () => {
      try {
        this._befores.forEach(fn => fn(testContext));
        await testInterpreter.interpretTest(instructionSequence);
        this._afters.forEach(fn => fn(testContext));
      } catch (e) {
        e.message +=
          "\n\n" +
          chalk.bold(title) +
          "\n" +
          instructionSequence.toString() +
          "\n";

        throw e;
      }
    });
  }
}
