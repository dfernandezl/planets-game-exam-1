package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;

import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public abstract class InstructionMatcher {
    private Pattern pattern;
    private Predicate<Context> precondition = (context) -> true;

    public InstructionMatcher(String regExp) {
        pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
    }

    public InstructionMatcherMatch match(String source) {
        var matcher = pattern.matcher(source);
        var isMatch = matcher.find(0);
        if (!isMatch) return null;

        return new InstructionMatcherMatch(this, matcher.toMatchResult());
    }

    public void andPrecondition(Predicate<Context> additionalPrecondition) {
        this.precondition = this.precondition.and(additionalPrecondition);
    }

    public Predicate<Context> getPrecondition() {
        return precondition;
    }

    public abstract void interpretMatch(MatchResult match, Instruction instruction, Context context);
}
