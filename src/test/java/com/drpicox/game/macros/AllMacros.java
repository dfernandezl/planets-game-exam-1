package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class AllMacros implements RootMacroDecoder {


    private List<Macro> macros;

    public AllMacros(List<Macro> macros, MatcherMacro matcherMacro) {
        this.macros = new LinkedList<>(macros);

        moveMatcherMacroToLast(this.macros, matcherMacro);
    }

    private void moveMatcherMacroToLast(List<Macro> macros, MatcherMacro matcherMacro) {
        macros.remove(matcherMacro);
        macros.add(matcherMacro);
    }

    public List<Instruction> decodeInstructions(String preformat, int firstLineNumber, List<String> instructionsSources) {
        var result = new LinkedList<Instruction>();

        var lineNumber = firstLineNumber;
        for (var source: instructionsSources) {
            var newInstructions = this.decodeInstruction(preformat + lineNumber, source);
            if (newInstructions != null) {
                result.addAll(newInstructions);
            }
            lineNumber += 1;
        }

        return result;
    }

    private List<Instruction> decodeInstruction(String lineNumber, String source) {
        for (var macro: macros) {
            var newInstructions = macro.decodeInstructions(lineNumber, source, this);
            if (newInstructions != null) {
                return newInstructions;
            }
        }
        return null;
    }
}
