package com.powerup.square.persistence.adapter;

import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.repository.IPlayerServiceHandlerRepository;
import com.powerup.square.persistence.entity.PlayerEntity;
import com.powerup.square.domain.exceptions.SexProvidedDoesntExistException;
import com.powerup.square.domain.exceptions.SexProvidedIsNotACharacterOnlyException;
import com.powerup.square.persistence.mapper.IPlayerMapper;
import com.powerup.square.persistence.repository.IPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerJpaAdapter implements IPlayerServiceHandlerRepository {

    private final IPlayerRepository iPlayerRepository;
    private final IPlayerMapper iPlayerMapper;

    public PlayerJpaAdapter(IPlayerRepository iPlayerRepository, IPlayerMapper iPlayerMapper) {
        this.iPlayerRepository = iPlayerRepository;
        this.iPlayerMapper = iPlayerMapper;
    }


    @Override
    public void savePlayer(Player player) {
        // age must be given wit a single letter
        if(player.getSex().length() > 1)
        {
            throw new SexProvidedIsNotACharacterOnlyException();
        // also, only will allow F/M
        } else if(!player.getSex().equals("F") &&
                !player.getSex().equals("M"))
        {
            throw new SexProvidedDoesntExistException();
        }

        PlayerEntity playerEntity = iPlayerMapper.toPlayerEntity(player);
        iPlayerRepository.save(playerEntity);
    }

    @Override
    public List<Player> getAllPlayers() {
        return iPlayerMapper.toPlayerList((List<PlayerEntity>) iPlayerRepository.findAll());
    }

    @Override
    public Player getPlayerByFirstName(String firstName) {
        return iPlayerRepository.findByFirstName(firstName);
    }

    @Override
    public Boolean existsByFirstName(String firstName) {
        return iPlayerRepository.existsByFirstName(firstName);
    }


}
