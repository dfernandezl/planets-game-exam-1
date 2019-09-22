package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import org.springframework.stereotype.Component;

@Component
public class CommandRunnerController {

    private CommandController commandController;
    private CommandRunnerCollector commandRunnerCollector;

    public CommandRunnerController(CommandController commandController, CommandRunnerCollector commandRunnerCollector) {
        this.commandController = commandController;
        this.commandRunnerCollector = commandRunnerCollector;
    }

    public void runAll() {
        commandRunnerCollector.listAll().forEach(runner -> runner.run());
    }
}
