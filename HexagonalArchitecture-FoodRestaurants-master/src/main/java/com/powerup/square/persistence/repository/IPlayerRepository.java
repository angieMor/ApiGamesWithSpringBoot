package com.powerup.square.persistence.repository;

import com.powerup.square.domain.model.Player;
import com.powerup.square.persistence.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends CrudRepository<PlayerEntity, Long> {
    Player findByFirstName(String firstName);

    Boolean existsByFirstName(String firstName);

}
