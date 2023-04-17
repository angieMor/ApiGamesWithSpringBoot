package com.powerup.square.persistence.repository;


import com.powerup.square.domain.model.Game;
import com.powerup.square.persistence.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Query Methods
/*
*       GameEntity, entity to make the crud
*       Long, type of the PK
* */
@Repository
public interface IGameRepository extends CrudRepository<GameEntity, Long> {

    List<GameEntity> findAllByOrderByGameNameAsc();

    Game getGameByGameName(String gameName);

    Boolean existsByGameName(String gameName);
}
