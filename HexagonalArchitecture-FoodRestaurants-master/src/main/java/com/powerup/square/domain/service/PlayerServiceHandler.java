package com.powerup.square.domain.service;

import com.powerup.square.domain.exceptions.PlayerFirstNameAlreadyExist;
import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.mapper.IPlayerRequestMapper;
import com.powerup.square.domain.repository.IPlayerServiceHandlerRepository;
import com.powerup.square.domain.dto.PlayerRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerServiceHandler {

    private IPlayerServiceHandlerRepository iPlayerServiceHandlerRepository;
    private IPlayerRequestMapper iPlayerRequestMapper;

    public PlayerServiceHandler(IPlayerServiceHandlerRepository iPlayerServiceHandlerRepository, IPlayerRequestMapper iPlayerRequestMapper) {
        this.iPlayerServiceHandlerRepository = iPlayerServiceHandlerRepository;
        this.iPlayerRequestMapper = iPlayerRequestMapper;
    }

    public void savePlayer(PlayerRequest playerRequest){
        if(iPlayerServiceHandlerRepository.existsByFirstName(playerRequest.getFirstName())){
            throw new PlayerFirstNameAlreadyExist();
        }
        // Map playerRequest into a Player object model
        Player player = iPlayerRequestMapper.toPlayer(playerRequest);
        player.setId(-1L);

        iPlayerServiceHandlerRepository.savePlayer(player);
    }

    public Player getPlayerByFirstName(String firstName){
        return iPlayerServiceHandlerRepository.getPlayerByFirstName(firstName);
    }

    public Boolean existsByFirstName(String firstName){
        return iPlayerServiceHandlerRepository.existsByFirstName(firstName);
    }

    public List<Player> getAllPlayers(){
        return iPlayerServiceHandlerRepository.getAllPlayers();
    }
}
