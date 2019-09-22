package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;

import java.util.regex.MatchResult;

public class InstructionMatcherMatch {
    private InstructionMatcher instructionMatcher;
    private MatchResult matchResult;

    public InstructionMatcherMatch(InstructionMatcher instructionMatcher, MatchResult matchResult) {
        this.instructionMatcher = instructionMatcher;
        this.matchResult = matchResult;
    }

    public InstructionMatcher getInstructionMatcher() {
        return instructionMatcher;
    }

    public int size() {
        return matchResult.end() - matchResult.start() + 1;
    }

    public void interpretInstruction(Instruction instruction, Context context) {
        this.instructionMatcher.interpretMatch(matchResult, instruction, context);
    }
}
