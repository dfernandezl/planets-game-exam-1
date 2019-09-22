package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import com.drpicox.game.interpreter.Snapshot;
import com.drpicox.game.interpreter.Snapshots;
import org.springframework.stereotype.Component;

import java.util.regex.MatchResult;

@Component
public class SnapshotMacro extends AbstractRegExpMatcher {

    public static String RESPONSE_CONTEXT_NAME = "snapshotResponseName";

    public SnapshotMacro() {
        super("\\s*<!--\\s+SNAPSHOT\\s+([^\\s]+)\\s+status=(\\d+)\\s+-+->\\s*");
    }

    @Override
    protected void interpretMatch(MatchResult match, Instruction instruction, Context context) {
        var name = match.group(1);
        var expectedStatus = Integer.parseInt(match.group(2));
        var snapshot = context.wantFor(Snapshot.class);
        var snapshots = context.wantFor(Snapshots.class);

        snapshots.execute(name, snapshot, expectedStatus);
    }
}
