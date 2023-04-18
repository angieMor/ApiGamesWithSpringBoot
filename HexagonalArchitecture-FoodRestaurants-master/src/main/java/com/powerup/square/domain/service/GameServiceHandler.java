package com.powerup.square.domain.service;

import com.powerup.square.domain.exceptions.GameNameAlreadyExistException;
import com.powerup.square.domain.mapper.IGameRequestMapper;
import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.repository.IGameServiceHandlerRepository;
import com.powerup.square.domain.dto.GameRequest;
import com.powerup.square.domain.exceptions.DateLaunchedProvidedIsNotADateTypeException;
import com.powerup.square.domain.exceptions.GameNameProvidedDoesNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@Transactional
public class GameServiceHandler {

    private IGameServiceHandlerRepository iGameServiceHandlerRepository;
    private IGameRequestMapper gameRequestMapper;

    public GameServiceHandler(IGameServiceHandlerRepository iGameServiceHandlerRepository, IGameRequestMapper gameRequestMapper) {
        this.iGameServiceHandlerRepository = iGameServiceHandlerRepository;
        this.gameRequestMapper = gameRequestMapper;
    }

    public Game saveGame(GameRequest gameRequest){
        if(iGameServiceHandlerRepository.existsByGameName(gameRequest.getGameName())){
            throw new GameNameAlreadyExistException();
        }
        // Map gameRequest into a Game object model
        Game game = gameRequestMapper.toGame(gameRequest);
        game.setId(-1L);

        try{
            // adding HH/mm to DateLaunched to convert it into LocalDateTime type
            String date = game.getDateLaunched() + " 00:00";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

            // if successful, is converted again into String
            String newDateLaunched =  dateTime.format(formatter);

            game.setDateLaunched(newDateLaunched);

            // saving gameEntity into DB
            return iGameServiceHandlerRepository.saveGame(game);

        } catch (DateTimeParseException i) {
            throw new DateLaunchedProvidedIsNotADateTypeException();
        }

    }

    public Game getGameByGameName(String gameName){
        if(!iGameServiceHandlerRepository.existsByGameName(gameName)){
            throw new GameNameProvidedDoesNotExistException();
        }
        return iGameServiceHandlerRepository.getGameByGameName(gameName);
    }

    public Boolean existsByGameName(String gameName){
        return iGameServiceHandlerRepository.existsByGameName(gameName);
    }

    public List<Game> getAllGames(){
        return iGameServiceHandlerRepository.getAllGames();
    }
}
