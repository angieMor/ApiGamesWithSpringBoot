package com.powerup.square.persistence.mapper;

import com.powerup.square.domain.model.Game;
import com.powerup.square.persistence.entity.GameEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IGameMapper {

    // converts GameEntity to Game
    Game toGame(GameEntity gameEntity);

    // converts Game to GameEntity
    GameEntity toGameEntity(Game game);

    List<Game> toGameList(List<GameEntity> gameEntityList);
//    List<GameEntity> toGameEntityList(List<Game> game);

}
