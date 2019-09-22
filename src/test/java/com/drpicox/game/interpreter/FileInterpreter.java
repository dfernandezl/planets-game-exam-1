package com.drpicox.game.interpreter;

import com.drpicox.game.macros.AllMacros;
import org.junit.jupiter.api.DynamicTest;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class FileInterpreter {

    private AllMacros allMacros;
    private TestInterpreter testInterpreter;

    public FileInterpreter(AllMacros allMacros, TestInterpreter testInterpreter) {
        this.allMacros = allMacros;
        this.testInterpreter = testInterpreter;
    }

    public List<DynamicTest> interpretFile(String file, Context context) {
        var tokens = new FileTokenizer(file);

        return this.interpretFile(tokens, context);
    }

    private List<DynamicTest> interpretFile(FileTokenizer tokens, Context context) {
        var tests = new LinkedList<DynamicTest>();

        this.skipUntilTest(tokens);
        while (!tokens.eof()) {
            var test = this.interpretTest(tokens, context);
            tests.add(test);
        }

        return tests;
    }

    private void skipUntilTest(FileTokenizer tokens) {
        tokens.skipUntil("^[^#]*##[^#].*");
    }

    private InstructionSequence acceptTestInstructions(FileTokenizer tokens) {
        var lineNumber = tokens.getLineNumber();
        var instructionsSources = tokens.acceptUntil("^[^#]*##[^#].*");

        var instructions = this.allMacros.decodeInstructions("", lineNumber, instructionsSources);
        return new InstructionSequence(instructions);
    }

    private DynamicTest interpretTest(FileTokenizer tokens, Context context) {
        var title = tokens.accept();
        var testContext = context.clone();
        var instructionSequence = this.acceptTestInstructions(tokens);
        return testInterpreter.interpretTest(title, testContext, instructionSequence);
    }
}
