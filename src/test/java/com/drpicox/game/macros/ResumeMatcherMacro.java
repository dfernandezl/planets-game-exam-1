package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class ResumeMatcherMacro extends AbstractRegExpMatcher {

    public ResumeMatcherMacro() {
        super("\\s*<!--\\s+RESUME\\s+MATCHER\\s+-+->\\s*");
    }

    @Override
    protected void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        context.remove("matcherPaused");
    }
}
