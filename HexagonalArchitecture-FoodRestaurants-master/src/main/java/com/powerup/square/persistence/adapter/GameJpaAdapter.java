package com.powerup.square.persistence.adapter;

import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.repository.IGameServiceHandlerRepository;
import com.powerup.square.persistence.repository.IGameRepository;
import com.powerup.square.persistence.entity.GameEntity;
import com.powerup.square.persistence.mapper.IGameMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameJpaAdapter implements IGameServiceHandlerRepository {

    private final IGameRepository gameRepository;
    private final IGameMapper gameMapper;

    @Override
    public void saveGame(Game game){
        GameEntity gameEntity = gameMapper.toGameEntity(game);

        // saving gameEntity into DB
        gameRepository.save(gameEntity);
    }

    @Override
    public Game getGameByGameName(String gameName) {
        return gameRepository.getGameByGameName(gameName);
    }

    @Override
    public Boolean existsByGameName(String gameName) {
        return gameRepository.existsByGameName(gameName);
    }

    @Override
    public List<Game> getAllGames() {
        return gameMapper.toGameList((List<GameEntity>) gameRepository.findAllByOrderByGameNameAsc());
    }

}
