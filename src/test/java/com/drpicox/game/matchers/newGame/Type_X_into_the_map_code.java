package com.drpicox.game.matchers.newGame;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Type_X_into_the_map_code extends NewGameInstructionMatcher {
    public Type_X_into_the_map_code() {
        super("Type _([^_]+)_ into the _map code_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var value = match.group(1);
        context.wantJson("newGame").set("mapCode", value);
    }
}
