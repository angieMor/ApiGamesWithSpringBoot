package com.powerup.square.domain.mapper;

import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.dto.GameRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IGameRequestMapper {

    Game toGame(GameRequest gameRequest);

}
