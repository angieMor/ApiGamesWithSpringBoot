package com.powerup.square.domain.repository;

import com.powerup.square.domain.model.Game;
import java.util.List;

public interface IGameServiceHandlerRepository {

    Game saveGame(Game game);

    Game getGameByGameName(String gameName);

    Boolean existsByGameName(String gameName);
    List<Game> getAllGames();
}
