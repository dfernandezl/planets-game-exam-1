package com.drpicox.game.matchers.newGame;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.interpreter.Snapshot;
import com.drpicox.game.matchers.OnResponseShowBodyMessageAlert;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Click_the_Add_player_button extends NewGameInstructionMatcher {
    public Click_the_Add_player_button() {
        super("Click the _Add player_ button");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var players = context.wantJson("newGame").get("players");
        players.add(new Json("{\"race\":\"Human\"}"));
    }
}
