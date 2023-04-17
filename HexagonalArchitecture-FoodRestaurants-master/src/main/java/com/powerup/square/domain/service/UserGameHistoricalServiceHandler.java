package com.powerup.square.domain.service;

import com.powerup.square.domain.exceptions.GameNameProvidedDoesNotExistException;
import com.powerup.square.domain.exceptions.HoursToRemoveShouldNotBeGreaterThanTheOnesRegisteredException;
import com.powerup.square.domain.exceptions.PlayerFirstNameProvidedDoesNotExistException;
import com.powerup.square.domain.mapper.IUserGameHistoricalResponseMapper;
import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.model.UserGameHistorical;
import com.powerup.square.domain.repository.IUserGameHistoricalServiceHandlerRepository;
import com.powerup.square.domain.mapper.IUserGameHistoricalRequestMapper;

import com.powerup.square.domain.dto.UserGameHistoricalRequest;
import com.powerup.square.domain.dto.UserGameHistoricalResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserGameHistoricalServiceHandler {

    private IUserGameHistoricalServiceHandlerRepository iUserGameHistoricalServiceHandlerRepository;
    private IUserGameHistoricalRequestMapper iUserGameHistoricalRequestMapper;
    private IUserGameHistoricalResponseMapper iUserGameHistoricalResponseMapper;
    private GameServiceHandler gameServiceHandler;
    private PlayerServiceHandler playerServiceHandler;

    public UserGameHistoricalServiceHandler(IUserGameHistoricalServiceHandlerRepository iUserGameHistoricalServiceHandlerRepository, IUserGameHistoricalRequestMapper iUserGameHistoricalRequestMapper, IUserGameHistoricalResponseMapper iUserGameHistoricalResponseMapper, GameServiceHandler gameServiceHandler, PlayerServiceHandler playerServiceHandler) {
        this.iUserGameHistoricalServiceHandlerRepository = iUserGameHistoricalServiceHandlerRepository;
        this.iUserGameHistoricalRequestMapper = iUserGameHistoricalRequestMapper;
        this.iUserGameHistoricalResponseMapper = iUserGameHistoricalResponseMapper;
        this.gameServiceHandler = gameServiceHandler;
        this.playerServiceHandler = playerServiceHandler;
    }

    public UserGameHistorical getUserGameHistoricalData(UserGameHistoricalRequest userGameHistoricalRequest){

        if(!gameServiceHandler.existsByGameName(userGameHistoricalRequest.getGameName())){
            throw new GameNameProvidedDoesNotExistException();
        }
        if(!playerServiceHandler.existsByFirstName(userGameHistoricalRequest.getFirstName())){
            throw new PlayerFirstNameProvidedDoesNotExistException();
        }

        Game game = gameServiceHandler.getGameByGameName(userGameHistoricalRequest.getGameName());
        Player player = playerServiceHandler.getPlayerByFirstName(userGameHistoricalRequest.getFirstName());

        return getByGameIdAndByPlayerId(game.getId(), player.getId());
    }

    public void addHoursOfGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest){

        UserGameHistorical userGameHistorical = getUserGameHistoricalData(userGameHistoricalRequest);

        iUserGameHistoricalServiceHandlerRepository.addHoursOfGameForAPlayer(userGameHistoricalRequest, userGameHistorical);
    }

    public UserGameHistorical getByGameIdAndByPlayerId(Long gameId, Long playerId){
        return iUserGameHistoricalServiceHandlerRepository.findByGameIdAndPlayerId(gameId,playerId);
    }

    public void editHoursOfGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest){
        UserGameHistorical userGameHistorical = getUserGameHistoricalData(userGameHistoricalRequest);

        iUserGameHistoricalServiceHandlerRepository.editHoursOfGameForAPlayer(userGameHistoricalRequest, userGameHistorical);
    }

    public void deleteHoursToGameForAPlayer(UserGameHistoricalRequest userGameHistoricalRequest){
        UserGameHistorical userGameHistorical = getUserGameHistoricalData(userGameHistoricalRequest);

        // Hours requested do reduce, must be lower than the hours_played record
        if(userGameHistoricalRequest.getHours() > userGameHistorical.getHoursPlayed()){
            throw new HoursToRemoveShouldNotBeGreaterThanTheOnesRegisteredException();
        }

        iUserGameHistoricalServiceHandlerRepository.deleteHoursToGameForAPlayer(userGameHistoricalRequest, userGameHistorical);
    }

    public List<UserGameHistoricalResponse> shapeResponse(List<UserGameHistorical> top10){
        List<UserGameHistoricalResponse> newListResponse = new ArrayList<>();

        for(UserGameHistorical userRecord : top10) {

            UserGameHistoricalResponse userHistorical = new UserGameHistoricalResponse(
                    userRecord.getHoursPlayed(),
                    userRecord.getGame().getGameName(),
                    userRecord.getPlayer().getFirstName() + " "+userRecord.getPlayer().getLastname(),
                    userRecord.getPlayer().getUsername()
            );
            newListResponse.add(userHistorical);
        }
        return newListResponse;
    }

    public List<UserGameHistoricalResponse> getTop10OfPlayersByGame(String gameName){
        if(!gameServiceHandler.existsByGameName(gameName)){
            throw new GameNameProvidedDoesNotExistException();
        }
        Long gameId = gameServiceHandler.getGameByGameName(gameName).getId();
        List<UserGameHistorical> top10 = iUserGameHistoricalServiceHandlerRepository.getTop10OfPlayersByGame(gameId);

        return shapeResponse(top10);
    }

    public List<UserGameHistoricalResponse> getTop10OfGamesPlayedByPlayer(String playerFirstName){
        if(!playerServiceHandler.existsByFirstName(playerFirstName)){
            throw new PlayerFirstNameProvidedDoesNotExistException();
        }
        Long playerId = playerServiceHandler.getPlayerByFirstName(playerFirstName).getId();

        List<UserGameHistorical> top10GamesByPlayer = iUserGameHistoricalServiceHandlerRepository.getTop10OfGamesPlayedByPlayer(playerId);

        return shapeResponse(top10GamesByPlayer);
    }

    public List<UserGameHistoricalResponse> getGeneralTop10(){
        List<UserGameHistorical> globalTop10 = iUserGameHistoricalServiceHandlerRepository.getGeneralTop10();

        return shapeResponse(globalTop10);
    }
}
