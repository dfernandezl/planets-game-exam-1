package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class TitleMacro extends AbstractRegExpMatcher {

    public TitleMacro() {
        super("###[^#].*");
    }

    @Override
    protected void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        context.set("currentTitle", instruction.getSource());
    }
}
