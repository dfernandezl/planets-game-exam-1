package com.drpicox.game.interpreter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

@Component
public class CleanupRepositories implements Consumer<Context> {

    private List<JpaRepository> repositories;

    public CleanupRepositories(List<JpaRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void accept(Context context) {
        var fail = new AtomicBoolean(true);
        var times = 0;
        while (times < repositories.size() && fail.get()) {
            fail.set(false);
            times += 1;
            repositories.forEach(r -> {
                try {
                    r.deleteAll();
                } catch (Throwable t) {
                    fail.set(true);
                }
            });
        }
        repositories.forEach(r -> r.deleteAll());
    }
}
