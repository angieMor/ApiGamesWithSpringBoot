package com.powerup.square.domain.mapper;

import com.powerup.square.domain.model.UserGameHistorical;
import com.powerup.square.domain.dto.UserGameHistoricalRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserGameHistoricalRequestMapper {

    UserGameHistorical toUserGameHistorical(UserGameHistoricalRequest userGameHistoricalRequest);


}
