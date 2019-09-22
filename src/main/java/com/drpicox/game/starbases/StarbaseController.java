package com.drpicox.game.starbases;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.players.Player;
import com.drpicox.game.stars.Star;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StarbaseController {

    private StarbaseRepository starbaseRepository;

    public StarbaseController(StarbaseRepository starbaseRepository) {
        this.starbaseRepository = starbaseRepository;
    }

    public void createStarbase(Star star, String name) {
        starbaseRepository.save(new Starbase(star, name));
    }

    public List<Starbase> listAll() {
        return starbaseRepository.findAll();
    }

    public void produceFuel(Starbase starbase) {
        starbase.produceFuel();
        starbaseRepository.save(starbase);
    }

    public void consumeFuel(Starbase starbase, int amount) {
        starbase.consumeFuel(amount);
        starbaseRepository.save(starbase);
    }
}
