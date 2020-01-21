package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.matchers.AllMatchers;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class MatcherMacro extends AbstractRegExpMatcher {

    private AllMatchers allMatchers;

    public MatcherMacro(AllMatchers allMatchers) {
        super("^[\\s>]+[^\\s>].*");
        this.allMatchers = allMatchers;
    }

    @Override
    protected void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        allMatchers.interpretInstruction(instruction, context);
    }
}
