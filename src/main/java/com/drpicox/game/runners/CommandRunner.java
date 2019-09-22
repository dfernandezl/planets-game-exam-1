package com.drpicox.game.runners;

public interface CommandRunner extends Runnable {

    int getPriority();
    void run();

}
