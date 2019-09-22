package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Snapshot;

import static com.drpicox.game.tools.JsonSubject.assertThat;

public class OnResponseShowBodyMessageAlert implements Runnable {
    private Context context;

    public OnResponseShowBodyMessageAlert(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        var snapshot = context.wantFor(Snapshot.class);
        var response = snapshot.getResponse();
        assertThat(response).at("message").isString();
        context.set("alert", response.getAsString("message"));
    }
}
