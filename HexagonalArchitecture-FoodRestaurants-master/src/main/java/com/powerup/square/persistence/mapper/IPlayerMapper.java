package com.powerup.square.persistence.mapper;

import com.powerup.square.domain.model.Player;
import com.powerup.square.persistence.entity.PlayerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlayerMapper {

    Player toPlayer(PlayerEntity playerEntity);
    PlayerEntity toPlayerEntity(Player player);

    List<Player> toPlayerList(List<PlayerEntity> playerEntity);



}
