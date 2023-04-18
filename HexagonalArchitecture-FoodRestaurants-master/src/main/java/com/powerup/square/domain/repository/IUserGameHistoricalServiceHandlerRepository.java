package com.powerup.square.domain.repository;


import com.powerup.square.domain.model.UserGameHistorical;
import com.powerup.square.domain.dto.UserGameHistoricalRequest;

import java.util.List;

public interface IUserGameHistoricalServiceHandlerRepository {
    UserGameHistorical findByGameIdAndPlayerId(Long gameId, Long playerId);
    UserGameHistorical addHoursOfGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest, UserGameHistorical userGameHistorical);
    UserGameHistorical editHoursOfGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest, UserGameHistorical userGameHistorical);
    UserGameHistorical deleteHoursToGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest, UserGameHistorical userGameHistorical);

    List<UserGameHistorical> getTop10OfPlayersByGame(Long gameId);

    List<UserGameHistorical> getTop10OfGamesPlayedByPlayer(Long playerId);

    List<UserGameHistorical> getGeneralTop10();


}
