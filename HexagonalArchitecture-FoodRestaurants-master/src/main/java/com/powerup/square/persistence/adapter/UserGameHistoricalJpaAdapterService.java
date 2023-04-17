package com.powerup.square.persistence.adapter;

import com.powerup.square.domain.model.UserGameHistorical;
import com.powerup.square.domain.repository.IUserGameHistoricalServiceHandlerRepository;
import com.powerup.square.domain.dto.UserGameHistoricalRequest;
import com.powerup.square.persistence.entity.UserGameHistoricalEntity;
import com.powerup.square.persistence.mapper.IUserGameHistoricalMapper;
import com.powerup.square.persistence.repository.IUserGameHistoricalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGameHistoricalJpaAdapterService implements IUserGameHistoricalServiceHandlerRepository {

    private final IUserGameHistoricalRepository iUserGameHistoricalRepository;
    private final IUserGameHistoricalMapper iUserGameHistoricalMapper;

    public UserGameHistoricalJpaAdapterService(IUserGameHistoricalRepository iUserGameHistoricalRepository, IUserGameHistoricalMapper iUserGameHistoricalMapper) {
        this.iUserGameHistoricalRepository = iUserGameHistoricalRepository;
        this.iUserGameHistoricalMapper = iUserGameHistoricalMapper;
    }

    @Override
    public void addHoursOfGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest,
                                                UserGameHistorical userGameHistorical) {

        UserGameHistoricalEntity addHoursPlayedToUserGameHistoricalHours = iUserGameHistoricalMapper.
                toUserGameHistoricalEntity(userGameHistorical);
        addHoursPlayedToUserGameHistoricalHours.setHoursPlayed(userGameHistorical.getHoursPlayed() +
                userGameHistoricalRequest.getHours());

        iUserGameHistoricalRepository.save(addHoursPlayedToUserGameHistoricalHours);
    }

    @Override
    public UserGameHistorical findByGameIdAndPlayerId(Long gameId, Long playerId) {
        return iUserGameHistoricalMapper.toUserGameHistorical(iUserGameHistoricalRepository.
                findByGameIdAndPlayerId(gameId, playerId));
    }

    @Override
    public void editHoursOfGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest,
                                          UserGameHistorical userGameHistorical) {

        UserGameHistoricalEntity editHours = iUserGameHistoricalMapper.toUserGameHistoricalEntity(userGameHistorical);
        editHours.setHoursPlayed(userGameHistoricalRequest.getHours());

        iUserGameHistoricalRepository.save(editHours);
    }

    @Override
    public void deleteHoursToGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest,
                                            UserGameHistorical userGameHistorical) {

        UserGameHistoricalEntity deleteHoursOfGamePlayed = iUserGameHistoricalMapper.toUserGameHistoricalEntity(userGameHistorical);
        deleteHoursOfGamePlayed.setHoursPlayed(userGameHistorical.getHoursPlayed() - userGameHistoricalRequest.getHours());

        iUserGameHistoricalRepository.save(deleteHoursOfGamePlayed);
    }

    @Override
    public List<UserGameHistorical> getTop10OfPlayersByGame(Long gameId) {
        return iUserGameHistoricalMapper.toUserGameHistoricalList(iUserGameHistoricalRepository.findTop10OfGameByHoursPlayedDesc(gameId));
    }

    @Override
    public List<UserGameHistorical> getTop10OfGamesPlayedByPlayer(Long playerId) {
        return iUserGameHistoricalMapper.toUserGameHistoricalList(iUserGameHistoricalRepository.findTop10OfGamesPlayedByPlayer(playerId));
    }

    @Override
    public List<UserGameHistorical> getGeneralTop10() {
        return iUserGameHistoricalMapper.toUserGameHistoricalList(iUserGameHistoricalRepository.findTop10ByOrderByHoursPlayedDesc());
    }


}
