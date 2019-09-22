package com.drpicox.game.matchers.newGame;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Select_X_into_the_Race_Y extends NewGameInstructionMatcher {
    public Select_X_into_the_Race_Y() {
        super("Select _([^_]+)_ into the _Race (\\d)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var value = match.group(1);
        var index = Integer.parseInt(match.group(2)) - 1;
        context.wantJson("newGame")
                .set("players["+index+"].race", value);
    }
}
