package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public abstract class InstructionMatcher {
    private Pattern pattern;
    private List<String> requirements = new ArrayList<>();
    private List<String> exclusions = new ArrayList<>();

    public InstructionMatcher(String regExp) {
        pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
    }

    public InstructionMatcherMatch match(String source) {
        var matcher = pattern.matcher(source);
        var isMatch = matcher.find(0);
        if (!isMatch) return null;

        return new InstructionMatcherMatch(this, matcher.toMatchResult());
    }

    public boolean verifyContext(Context context) {
        return requirements.stream().allMatch(r -> context.has(r)) &&
                exclusions.stream().allMatch(r -> !context.has(r));
    }

    public void andRequires(String...requirements) {
        this.requirements.addAll(Arrays.asList(requirements));
    }

    public void andExcludes(String...exclusions) {
        this.exclusions.addAll(Arrays.asList(exclusions));
    }

    public abstract void interpretMatch(MatchResult match, Instruction instruction, Context context);

    public List<String> getRequirements() {
        return requirements;
    }

    public List<String> getExclusions() {
        return exclusions;
    }
}
