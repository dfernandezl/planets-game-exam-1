package com.drpicox.game.matchers.login;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Snapshot;

public class OnSuccessSetGameInContext implements Runnable {
    private Context context;
    private Snapshot snapshot;

    public OnSuccessSetGameInContext(Context context, Snapshot snapshot) {
        this.context = context;
        this.snapshot = snapshot;
    }

    @Override
    public void run() {
        if (!snapshot.getResponse().keys().contains("playerId")) return;

        context.set("game", snapshot.getResponse());
        context.set("commands", snapshot.getResponse().get("commands"));
        context.remove("cellEntities");
        context.remove("it");
        context.remove("thatMessage");
    }
}
