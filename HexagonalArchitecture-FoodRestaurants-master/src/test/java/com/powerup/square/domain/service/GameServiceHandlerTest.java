package com.powerup.square.domain.service;

import com.powerup.square.domain.dto.GameRequest;
import com.powerup.square.domain.exceptions.GameNameAlreadyExistException;
import com.powerup.square.domain.exceptions.GameNameProvidedDoesNotExistException;
import com.powerup.square.domain.mapper.IGameRequestMapper;
import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.repository.IGameServiceHandlerRepository;
import com.powerup.square.domain.service.GameServiceHandler;
import com.powerup.square.domain.service.GameServiceHandlerDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class GameServiceHandlerTest {


    @InjectMocks
    GameServiceHandler gameServiceHandler;

    @Mock
    IGameServiceHandlerRepository iGameServiceHandlerRepository;

    @Mock
    IGameRequestMapper iGameRequestMapper;


    @Test
    void succesfullSaveGame() {

        Game game = GameServiceHandlerDataTest.obtainGame();
        GameRequest gameRequest = GameServiceHandlerDataTest.obtainGameRequest();
        Game savedGame = GameServiceHandlerDataTest.obtainGame();

        when(iGameServiceHandlerRepository.existsByGameName(gameRequest.getGameName())).thenReturn(false);
        when(iGameRequestMapper.toGame(gameRequest)).thenReturn(game);
        when(iGameServiceHandlerRepository.saveGame(game)).thenReturn(savedGame);

        Game result = gameServiceHandler.saveGame(gameRequest);

        assertEquals(savedGame, result);
        verify(iGameServiceHandlerRepository, times(1)).existsByGameName(gameRequest.getGameName());
        verify(iGameRequestMapper, times(1)).toGame(gameRequest);
        verify(iGameServiceHandlerRepository, times(1)).saveGame(game);
    }

    @Test
    void gameNameAlreadyExistException() {
        Game game = GameServiceHandlerDataTest.obtainGame();
        GameRequest gameRequest = GameServiceHandlerDataTest.obtainGameRequest();

        when(iGameServiceHandlerRepository.existsByGameName(gameRequest.getGameName())).thenReturn(true);

        assertThrows(GameNameAlreadyExistException.class, () -> gameServiceHandler.saveGame(gameRequest));

        verify(iGameServiceHandlerRepository).existsByGameName(gameRequest.getGameName());

        verify(iGameRequestMapper, never()).toGame(gameRequest);
        verify(iGameServiceHandlerRepository, never()).saveGame(game);
    }

    @Test
    void getGameByGameName() {
        String gameName = GameServiceHandlerDataTest.obtainGame().getGameName();
        Game expectedGame = GameServiceHandlerDataTest.obtainGame();

        when(!iGameServiceHandlerRepository.existsByGameName(gameName)).thenReturn(true);
        when(iGameServiceHandlerRepository.getGameByGameName(gameName)).thenReturn(expectedGame);

        Game result = gameServiceHandler.getGameByGameName(gameName);
        assertEquals(result, expectedGame);

        verify(iGameServiceHandlerRepository, times(1)).getGameByGameName(gameName);
        verify(iGameServiceHandlerRepository, times(1)).getGameByGameName(gameName);
    }

    @Test
    void GameNameProvidedDoesNotExistException(){
        String gameName = GameServiceHandlerDataTest.obtainGame().getGameName();

        when(!iGameServiceHandlerRepository.existsByGameName(gameName)).thenReturn(false);

        assertThrows(GameNameProvidedDoesNotExistException.class, () -> gameServiceHandler.getGameByGameName(gameName));

        verify(iGameServiceHandlerRepository).existsByGameName(gameName);

        verify(iGameServiceHandlerRepository, never()).getGameByGameName(gameName);
    }

    @Test
    void existsByGameName() {
        String gameName = GameServiceHandlerDataTest.obtainGame().getGameName();
        Boolean expectedBool = true;

        when(iGameServiceHandlerRepository.existsByGameName(gameName)).thenReturn(true);

        Boolean result = gameServiceHandler.existsByGameName(gameName);

        assertEquals(result, expectedBool);

        verify(iGameServiceHandlerRepository, times(1)).existsByGameName(gameName);
    }

    @Test
    void getAllGames() {
        List<Game> expectedListOfGames = GameServiceHandlerDataTest.obtainListOfGames();

        when(iGameServiceHandlerRepository.getAllGames()).thenReturn(expectedListOfGames);

        List<Game> result = gameServiceHandler.getAllGames();

        assertEquals(result, expectedListOfGames);
        verify(iGameServiceHandlerRepository, times(1)).getAllGames();
    }
}