package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.interpreter.Snapshot;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class Debug extends  InstructionMatcher {
    public Debug() {
        super("debug");
    }

    @Override
    public void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var message = new StringBuilder();
        var snapshot = context.get(Snapshot.class);
        if (snapshot != null ) {
            message.append("\n\nLast Snapshot:\n");
            message.append("  request        : ");
            message.append(snapshot.getMethod());
            message.append(" ");
            message.append(snapshot.getUrl());
            message.append("\n");
            message.append("  request body   : ").append(snapshot.getRequest()).append("\n");
            message.append("  response status: ").append(snapshot.getStatus()).append("\n");
            message.append("  response body  : ").append(snapshot.getResponse()).append("\n");
        }

        message.append("\n\nContext:\n");
        for (var key: context.keys()) {
            if (key.startsWith("com.drpicox.game.")) continue;
            message.append("  ");
            message.append(key);
            if (key.length() < 15)
                message.append("               ".substring(key.length()));
            message.append(": ");
            message.append(context.get(key).toString());
            message.append("\n");
        }
    }
}
