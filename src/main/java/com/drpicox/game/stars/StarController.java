package com.drpicox.game.stars;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.entities.EntityController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StarController {

    private EntityController entityController;
    private StarRepository starRepository;

    public StarController(EntityController entityController, StarRepository starRepository) {
        this.entityController = entityController;
        this.starRepository = starRepository;
    }

    public void createHomeworld(String name, Coordinates coordinates) {
        starRepository.save(new Star(name, coordinates, 100, 100));
    }
    public void createStar(String name, Coordinates coordinates) {
        starRepository.save(new Star(name, coordinates, 100, 0));
    }

    public void assignHomeworld(Player player) {
        var stars = this.listAll();
        var homeworld = stars.stream().filter(s -> !s.hasPlayer()).findFirst().get();
        entityController.assignPlayer(homeworld, player);
    }

    public List<Star> listAll() {
        return starRepository.findAll();
    }

    public Star getStar(Coordinates coordinates) {
        return starRepository.findByCoordinates(coordinates);
    }

    public void extractPopulation(Star star, int amount) {
        star.extractPopulation(amount);
        starRepository.save(star);
    }

    public void reproducePopulation(Star star) {
        star.reproducePopulation();
        starRepository.save(star);
    }

    public void looseBattle(Star star, Player player, int survivors) {
        star.looseBattle(player, survivors);
        starRepository.save(star);
    }

    public void winsBattle(Star star, int survivors) {
        star.winsBattle(survivors);
        starRepository.save(star);
    }


    public void digMinerals(Star star) {
        if (star.digMinerals())
            starRepository.save(star);
    }

    public boolean consumeMinerals(Star star, int amount) {
        var result = star.consumeMinerals(amount);
        if (result)
            starRepository.save(star);

        return result;
    }

    public void addPopulation(Star star, int amount) {
        star.addPopulation(amount);
        starRepository.save(star);
    }

    public void boostPopulation(Star star) {
        star.boostPoplation();
        starRepository.save(star);
    }
}
