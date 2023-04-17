package com.powerup.square.domain.mapper;

import com.powerup.square.domain.model.UserGameHistorical;
import com.powerup.square.domain.dto.UserGameHistoricalResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserGameHistoricalResponseMapper {

    List<UserGameHistoricalResponse> toUserGameHistoricalResponseList(List<UserGameHistorical> userGameHistorical);
}
