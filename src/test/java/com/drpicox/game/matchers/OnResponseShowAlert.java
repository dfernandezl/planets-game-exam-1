package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;

public class OnResponseShowAlert implements Runnable {
    private Context context;
    private String alert;

    public OnResponseShowAlert(Context context, String alert) {
        this.context = context;
        this.alert = alert;
    }

    @Override
    public void run() {
        context.set("alert", alert);
    }
}
