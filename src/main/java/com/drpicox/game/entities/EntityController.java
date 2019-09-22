package com.drpicox.game.entities;

import com.drpicox.game.players.Player;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

@Controller
public class EntityController {

    private EntityRepository entityRepository;

    public EntityController(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public void clear() {
        entityRepository.deleteAll();
    }

    public void assignPlayer(Entity entity, Player player) {
        entity.assignPlayer(player);
        entityRepository.save(entity);
    }

    public List<Entity> listAllOwnedBy(Player player) {
        return entityRepository.findAllByPlayer(player);
    }

    public List<Entity> listAllIn(Collection<Coordinates> coordinatesList) {
        return entityRepository.findAllByCoordinatesIn(coordinatesList);
    }

    public Entity get(Long entityId) {
        return entityRepository.findById(entityId).orElse(null);
    }
}
