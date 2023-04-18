package com.powerup.square.domain.service;

import com.powerup.square.domain.dto.UserGameHistoricalRequest;
import com.powerup.square.domain.dto.UserGameHistoricalResponse;
import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.model.UserGameHistorical;
import com.powerup.square.domain.repository.IGameServiceHandlerRepository;
import com.powerup.square.domain.repository.IPlayerServiceHandlerRepository;
import com.powerup.square.domain.repository.IUserGameHistoricalServiceHandlerRepository;
import com.powerup.square.domain.service.GameServiceHandlerDataTest;
import com.powerup.square.domain.service.PlayerServiceHandlerDataTest;
import com.powerup.square.domain.service.UserGameHistoricalServiceHandler;
import com.powerup.square.domain.service.UserGameHistoricalServiceHandlerDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserGameHistoricalServiceHandlerTest {

    @InjectMocks
    UserGameHistoricalServiceHandler userGameHistoricalServiceHandler;

    @Mock
    IUserGameHistoricalServiceHandlerRepository iUserGameHistoricalServiceHandlerRepository;

    @Mock
    IGameServiceHandlerRepository iGameServiceHandlerRepository;

    @Mock
    IPlayerServiceHandlerRepository iPlayerServiceHandlerRepository;

    @Test
    void addHoursOfGameForAPlayer() {
        UserGameHistoricalRequest userGameHistoricalRequest = UserGameHistoricalServiceHandlerDataTest.obtainUserGameHistoricalRequest();
        UserGameHistorical expectedUserGameHistorical = UserGameHistoricalServiceHandlerDataTest.obtainUserGameHistorical();
        Game game = GameServiceHandlerDataTest.obtainGame();
        Player player = PlayerServiceHandlerDataTest.obtainPlayer();

        when(!iGameServiceHandlerRepository.existsByGameName(userGameHistoricalRequest.getGameName())).thenReturn(true);
        when(!iPlayerServiceHandlerRepository.existsByFirstName(userGameHistoricalRequest.getFirstName())).thenReturn(true);
        when(iGameServiceHandlerRepository.getGameByGameName(userGameHistoricalRequest.getGameName())).thenReturn(game);
        when(iPlayerServiceHandlerRepository.getPlayerByFirstName(userGameHistoricalRequest.getFirstName())).thenReturn(player);
        when(iUserGameHistoricalServiceHandlerRepository.findByGameIdAndPlayerId(game.getId(), player.getId())).thenReturn(expectedUserGameHistorical);

        when(iUserGameHistoricalServiceHandlerRepository.addHoursOfGameForAPlayer(userGameHistoricalRequest, expectedUserGameHistorical)).thenReturn(expectedUserGameHistorical);

        UserGameHistorical result = userGameHistoricalServiceHandler.addHoursOfGameForAPlayer(userGameHistoricalRequest);
        assertEquals(result, expectedUserGameHistorical);

        verify(iGameServiceHandlerRepository).existsByGameName(userGameHistoricalRequest.getGameName());
        verify(iPlayerServiceHandlerRepository).existsByFirstName(userGameHistoricalRequest.getFirstName());
        verify(iGameServiceHandlerRepository).getGameByGameName(game.getGameName());
        verify(iPlayerServiceHandlerRepository).getPlayerByFirstName(userGameHistoricalRequest.getFirstName());
        verify(iUserGameHistoricalServiceHandlerRepository).findByGameIdAndPlayerId(game.getId(), player.getId());

        verify(iUserGameHistoricalServiceHandlerRepository).addHoursOfGameForAPlayer(userGameHistoricalRequest, expectedUserGameHistorical);
    }

    @Test
    void editHoursOfGameForAPlayer() {
        // Same code as before
        UserGameHistoricalRequest userGameHistoricalRequest = UserGameHistoricalServiceHandlerDataTest.obtainUserGameHistoricalRequest();
        UserGameHistorical expectedUserGameHistorical = UserGameHistoricalServiceHandlerDataTest.obtainUserGameHistorical();
        Game game = GameServiceHandlerDataTest.obtainGame();
        Player player = PlayerServiceHandlerDataTest.obtainPlayer();

        when(!iGameServiceHandlerRepository.existsByGameName(userGameHistoricalRequest.getGameName())).thenReturn(true);
        when(!iPlayerServiceHandlerRepository.existsByFirstName(userGameHistoricalRequest.getFirstName())).thenReturn(true);
        when(iGameServiceHandlerRepository.getGameByGameName(userGameHistoricalRequest.getGameName())).thenReturn(game);
        when(iPlayerServiceHandlerRepository.getPlayerByFirstName(userGameHistoricalRequest.getFirstName())).thenReturn(player);
        when(iUserGameHistoricalServiceHandlerRepository.findByGameIdAndPlayerId(game.getId(), player.getId())).thenReturn(expectedUserGameHistorical);
        //------------------------//

        when(iUserGameHistoricalServiceHandlerRepository.editHoursOfGameForAPlayer(userGameHistoricalRequest, expectedUserGameHistorical)).thenReturn(expectedUserGameHistorical);

        UserGameHistorical result = userGameHistoricalServiceHandler.editHoursOfGameForAPlayer(userGameHistoricalRequest);
        assertEquals(result, expectedUserGameHistorical);
        // Almost same code as before
        verify(iGameServiceHandlerRepository).existsByGameName(userGameHistoricalRequest.getGameName());
        verify(iPlayerServiceHandlerRepository).existsByFirstName(userGameHistoricalRequest.getFirstName());
        verify(iGameServiceHandlerRepository).getGameByGameName(game.getGameName());
        verify(iPlayerServiceHandlerRepository).getPlayerByFirstName(userGameHistoricalRequest.getFirstName());
        verify(iUserGameHistoricalServiceHandlerRepository).findByGameIdAndPlayerId(game.getId(), player.getId());

        verify(iUserGameHistoricalServiceHandlerRepository).editHoursOfGameForAPlayer(userGameHistoricalRequest, expectedUserGameHistorical);
    }

    @Test
    void deleteHoursToGameForAPlayer() {
        // Same code as before
        UserGameHistoricalRequest userGameHistoricalRequest = UserGameHistoricalServiceHandlerDataTest.obtainUserGameHistoricalRequest();
        UserGameHistorical expectedUserGameHistorical = UserGameHistoricalServiceHandlerDataTest.obtainUserGameHistorical();
        expectedUserGameHistorical.setHoursPlayed(15);

        Game game = GameServiceHandlerDataTest.obtainGame();
        Player player = PlayerServiceHandlerDataTest.obtainPlayer();

        when(!iGameServiceHandlerRepository.existsByGameName(userGameHistoricalRequest.getGameName())).thenReturn(true);
        when(!iPlayerServiceHandlerRepository.existsByFirstName(userGameHistoricalRequest.getFirstName())).thenReturn(true);
        when(iGameServiceHandlerRepository.getGameByGameName(userGameHistoricalRequest.getGameName())).thenReturn(game);
        when(iPlayerServiceHandlerRepository.getPlayerByFirstName(userGameHistoricalRequest.getFirstName())).thenReturn(player);
        when(iUserGameHistoricalServiceHandlerRepository.findByGameIdAndPlayerId(game.getId(), player.getId())).thenReturn(expectedUserGameHistorical);
        //------------------------//

        when(iUserGameHistoricalServiceHandlerRepository.deleteHoursToGameForAPlayer(userGameHistoricalRequest, expectedUserGameHistorical)).thenReturn(expectedUserGameHistorical);

        UserGameHistorical result = userGameHistoricalServiceHandler.deleteHoursToGameForAPlayer(userGameHistoricalRequest);
        assertEquals(result, expectedUserGameHistorical);

        // Almost same code as before
        verify(iGameServiceHandlerRepository).existsByGameName(userGameHistoricalRequest.getGameName());
        verify(iPlayerServiceHandlerRepository).existsByFirstName(userGameHistoricalRequest.getFirstName());
        verify(iGameServiceHandlerRepository).getGameByGameName(game.getGameName());
        verify(iPlayerServiceHandlerRepository).getPlayerByFirstName(userGameHistoricalRequest.getFirstName());
        verify(iUserGameHistoricalServiceHandlerRepository).findByGameIdAndPlayerId(game.getId(), player.getId());

        verify(iUserGameHistoricalServiceHandlerRepository).deleteHoursToGameForAPlayer(userGameHistoricalRequest, expectedUserGameHistorical);
    }

    @Test
    void getTop10OfPlayersByGame() {
        List<UserGameHistorical> top10 = UserGameHistoricalServiceHandlerDataTest.obtainListOfUserGameHistoricalForTop10ByGame();
        List<UserGameHistoricalResponse> expectedListOfUserGameHistoricalResponse = UserGameHistoricalServiceHandlerDataTest.obtainListOfUserGameHistoricalResponseForTop10ByGame();
        String gameName = GameServiceHandlerDataTest.obtainGame().getGameName();
        Game game = GameServiceHandlerDataTest.obtainGame();

        when(!iGameServiceHandlerRepository.existsByGameName(gameName)).thenReturn(true);
        when(iGameServiceHandlerRepository.getGameByGameName(gameName)).thenReturn(game);
        when(iUserGameHistoricalServiceHandlerRepository.getTop10OfPlayersByGame(game.getId())).thenReturn(top10);

        List<UserGameHistoricalResponse> result = userGameHistoricalServiceHandler.getTop10OfPlayersByGame(gameName);
        UserGameHistoricalResponse result0 = result.get(0);
        UserGameHistoricalResponse result9 = result.get(9);
        UserGameHistoricalResponse expectedListOfUserGameHistoricalResponse0 = expectedListOfUserGameHistoricalResponse.get(0);
        UserGameHistoricalResponse expectedListOfUserGameHistoricalResponse9 = expectedListOfUserGameHistoricalResponse.get(9);

        assertEquals(expectedListOfUserGameHistoricalResponse.size(), result.size());
        assertEquals(expectedListOfUserGameHistoricalResponse0.getUsername(), result0.getUsername());
        assertEquals(expectedListOfUserGameHistoricalResponse9.getUsername(), result9.getUsername());

        verify(iGameServiceHandlerRepository).existsByGameName(gameName);
        verify(iGameServiceHandlerRepository).getGameByGameName(gameName);
        verify(iUserGameHistoricalServiceHandlerRepository).getTop10OfPlayersByGame(game.getId());
    }

    @Test
    void getTop10OfGamesPlayedByPlayer() {
        List<UserGameHistorical> top10 = UserGameHistoricalServiceHandlerDataTest.obtainListOfUserGameHistoricalForTop10ByPlayer();
        List<UserGameHistoricalResponse> expectedListOfUserGameHistoricalResponse = UserGameHistoricalServiceHandlerDataTest.obtainListOfUserGameHistoricalResponseForTop10ByPlayer();
        Player player = PlayerServiceHandlerDataTest.obtainPlayer();

        when(!iPlayerServiceHandlerRepository.existsByFirstName(player.getFirstName())).thenReturn(true);
        when(iPlayerServiceHandlerRepository.getPlayerByFirstName(player.getFirstName())).thenReturn(player);
        when(iUserGameHistoricalServiceHandlerRepository.getTop10OfGamesPlayedByPlayer(player.getId())).thenReturn(top10);

        List<UserGameHistoricalResponse> result = userGameHistoricalServiceHandler.getTop10OfGamesPlayedByPlayer(player.getFirstName());
        UserGameHistoricalResponse result9 = result.get(9);
        UserGameHistoricalResponse expectedListOfUserGameHistoricalResponse9 = expectedListOfUserGameHistoricalResponse.get(9);

        assertEquals(expectedListOfUserGameHistoricalResponse.size(), result.size());
        assertEquals(result9.getGameName(), expectedListOfUserGameHistoricalResponse9.getGameName());

        verify(iPlayerServiceHandlerRepository).existsByFirstName(player.getFirstName());
        verify(iPlayerServiceHandlerRepository).getPlayerByFirstName(player.getFirstName());
        verify(iUserGameHistoricalServiceHandlerRepository).getTop10OfGamesPlayedByPlayer(player.getId());
    }

    @Test
    void getGeneralTop10() {
        List<UserGameHistorical> top10 = UserGameHistoricalServiceHandlerDataTest.obtainListOfUserGameHistoricalGeneralTop10();
        List<UserGameHistoricalResponse> expectedUserGameHistoricalResponse = UserGameHistoricalServiceHandlerDataTest.obtainListOfUserGameHistoricalResponseGeneralTop10();

        when(iUserGameHistoricalServiceHandlerRepository.getGeneralTop10()).thenReturn(top10);

        List<UserGameHistoricalResponse> result = userGameHistoricalServiceHandler.getGeneralTop10();
        UserGameHistoricalResponse result9 = result.get(9);
        UserGameHistoricalResponse expectedUserGameHistoricalResponse9 = expectedUserGameHistoricalResponse.get(9);

        assertEquals(result.size(), expectedUserGameHistoricalResponse.size());
        assertEquals(result9.getHoursPlayed(), expectedUserGameHistoricalResponse9.getHoursPlayed());

        verify(iUserGameHistoricalServiceHandlerRepository).getGeneralTop10();
    }
}