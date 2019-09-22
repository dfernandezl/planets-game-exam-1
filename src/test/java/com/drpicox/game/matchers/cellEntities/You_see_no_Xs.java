package com.drpicox.game.matchers.cellEntities;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.tools.Json;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.drpicox.game.tools.JsonSubject.assertThat;

@Component
public class You_see_no_Xs extends CellEntitiesInstructionMatcher {
    public You_see_no_Xs() {
        super("You see no _([^_]+)s_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var example = new Json("{}")
                .set("type", match.group(1));

        var cellEntities = (Json) context.get("cellEntities");
        assertThat(cellEntities).notContainsMatch(example);
    }
}
