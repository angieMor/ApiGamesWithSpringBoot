package com.powerup.square.persistence.mapper;

import com.powerup.square.domain.model.UserGameHistorical;
import com.powerup.square.persistence.entity.UserGameHistoricalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserGameHistoricalMapper {

    UserGameHistorical toUserGameHistorical(UserGameHistoricalEntity userGameHistoricalEntity);

    UserGameHistoricalEntity toUserGameHistoricalEntity(UserGameHistorical userGameHistorical);

    List<UserGameHistorical> toUserGameHistoricalList(List<UserGameHistoricalEntity> userGameHistoricalEntityList);
}
