package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

import static com.google.common.truth.Truth.assertThat;

@Component
public class Wait_for_an_alert_saying_X extends  InstructionMatcher {
    public Wait_for_an_alert_saying_X() {
        super("Wait for an alert saying _([^_]+)_");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var alert = (String) context.wantFor("alert");
        var expect = match.group(1);

        assertThat(alert.toLowerCase()).contains(expect.toLowerCase());
        context.remove("alert");
    }
}
