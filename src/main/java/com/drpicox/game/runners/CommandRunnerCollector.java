package com.drpicox.game.runners;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRunnerCollector {
    private List<CommandRunner> runners;

    public CommandRunnerCollector(List<CommandRunner> runners) {
        this.runners = new ArrayList<>(runners);
        this.runners.sort((r1, r2) -> {
            var p1 = r1.getPriority();
            var p2 = r2.getPriority();
            if (p1 < p2) return -1;
            if (p1 > p2) return +1;
            return r1.getClass().getName().compareTo(r2.getClass().getName());
        });
    }

    public List<CommandRunner> listAll() {
        return runners;
    }
}
