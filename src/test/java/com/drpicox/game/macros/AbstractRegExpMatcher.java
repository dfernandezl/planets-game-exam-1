package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public abstract class AbstractRegExpMatcher implements Macro {

    private Pattern pattern;

    public AbstractRegExpMatcher(String regExp) {
        this.pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public List<Instruction> decodeInstructions(String lineNumber, String instructionSource, RootMacroDecoder rootDecoder) {
        var matcher = pattern.matcher(instructionSource);
        var isMatch = matcher.find(0);
        if (!isMatch) return null;

        return Arrays.asList(
                new Instruction(lineNumber, instructionSource, (instruction, context) -> {
                    var match = matcher.toMatchResult();
                    this.interpretMatch(match, instruction, context);
                })
        );
    }

    protected abstract void interpretMatch(MatchResult match, Instruction instruction, Context context);
}
