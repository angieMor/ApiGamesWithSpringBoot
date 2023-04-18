package com.powerup.square.domain.repository;

import com.powerup.square.domain.model.Player;
import java.util.List;

public interface IPlayerServiceHandlerRepository {

    Player savePlayer(Player player);

    Player getPlayerByFirstName(String firstName);

    Boolean existsByFirstName(String firstName);
    List<Player> getAllPlayers();
}
