package com.powerup.square.domain.service;

import com.powerup.square.domain.dto.PlayerRequest;
import com.powerup.square.domain.exceptions.PlayerFirstNameAlreadyExist;
import com.powerup.square.domain.mapper.IPlayerRequestMapper;
import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.repository.IPlayerServiceHandlerRepository;
import com.powerup.square.domain.service.PlayerServiceHandler;
import com.powerup.square.domain.service.PlayerServiceHandlerDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PlayerServiceHandlerTest {

    @InjectMocks
    PlayerServiceHandler playerServiceHandler;

    @Mock
    IPlayerServiceHandlerRepository iPlayerServiceHandlerRepository;

    @Mock
    IPlayerRequestMapper iPlayerRequestMapper;

    @Test
    void savePlayer() {
        PlayerRequest playerRequest = PlayerServiceHandlerDataTest.obtainPlayerRequest();
        Player expectedPlayer = PlayerServiceHandlerDataTest.obtainPlayer();

        when(iPlayerServiceHandlerRepository.existsByFirstName(playerRequest.getFirstName())).thenReturn(false);
        when(iPlayerRequestMapper.toPlayer(playerRequest)).thenReturn(expectedPlayer);
        when(iPlayerServiceHandlerRepository.savePlayer(expectedPlayer)).thenReturn(expectedPlayer);

        Player result = playerServiceHandler.savePlayer(playerRequest);
        assertEquals(result, expectedPlayer);

        verify(iPlayerServiceHandlerRepository, times(1)).existsByFirstName(playerRequest.getFirstName());
        verify(iPlayerRequestMapper, times(1)).toPlayer(playerRequest);
        verify(iPlayerServiceHandlerRepository, times(1)).savePlayer(expectedPlayer);
    }

    @Test
    void playerFirstNameAlreadyExistException(){
        PlayerRequest playerRequest = PlayerServiceHandlerDataTest.obtainPlayerRequest();
        Player player = PlayerServiceHandlerDataTest.obtainPlayer();

        when(iPlayerServiceHandlerRepository.existsByFirstName(playerRequest.getFirstName())).thenReturn(true);

        assertThrows(PlayerFirstNameAlreadyExist.class, () -> playerServiceHandler.savePlayer(playerRequest));

        verify(iPlayerServiceHandlerRepository, times(1)).existsByFirstName(playerRequest.getFirstName());
        verify(iPlayerRequestMapper, never()).toPlayer(playerRequest);
        verify(iPlayerServiceHandlerRepository, never()).savePlayer(player);
    }

    @Test
    void getPlayerByFirstName() {
        String firstName = PlayerServiceHandlerDataTest.obtainPlayer().getFirstName();
        Player expectedPlayer = PlayerServiceHandlerDataTest.obtainPlayer();

        when(iPlayerServiceHandlerRepository.getPlayerByFirstName(firstName)).thenReturn(expectedPlayer);

        Player result = playerServiceHandler.getPlayerByFirstName(firstName);
        assertEquals(result, expectedPlayer);

        verify(iPlayerServiceHandlerRepository, times(1)).getPlayerByFirstName(firstName);
    }

    @Test
    void existsByFirstName() {
        String firstName = PlayerServiceHandlerDataTest.obtainPlayer().getFirstName();
        Boolean expectedBool = true;

        when(iPlayerServiceHandlerRepository.existsByFirstName(firstName)).thenReturn(expectedBool);

        Boolean result = playerServiceHandler.existsByFirstName(firstName);
        assertEquals(result, expectedBool);

        verify(iPlayerServiceHandlerRepository, times(1)).existsByFirstName(firstName);
    }

    @Test
    void getAllPlayers() {
        List<Player> expectedListOfPlayers = PlayerServiceHandlerDataTest.obtainPlayerList();

        when(iPlayerServiceHandlerRepository.getAllPlayers()).thenReturn(expectedListOfPlayers);

        List<Player> resultList = playerServiceHandler.getAllPlayers();
        assertEquals(resultList, expectedListOfPlayers);

        verify(iPlayerServiceHandlerRepository, times(1)).getAllPlayers();
    }
}