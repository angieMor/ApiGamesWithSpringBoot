package com.powerup.square.domain.mapper;

import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.dto.PlayerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlayerRequestMapper {

    Player toPlayer(PlayerRequest playerRequest);

}
