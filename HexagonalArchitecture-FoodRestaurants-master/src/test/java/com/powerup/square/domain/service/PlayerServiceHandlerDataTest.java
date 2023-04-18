package com.powerup.square.domain.service;

import com.powerup.square.domain.dto.PlayerRequest;
import com.powerup.square.domain.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerServiceHandlerDataTest {

    public static Player obtainPlayer(){
        return new Player(
                -1L,
                "Angie",
                "Moreno",
                "AngieMoruwu",
                26,
                "angie@gmail.com",
                "F"
        );
    }

    public static PlayerRequest obtainPlayerRequest(){
        PlayerRequest playerRequest = new PlayerRequest();

        playerRequest.setFirstName("Angie");
        playerRequest.setLastname("Moreno");
        playerRequest.setUsername("AngieMoruwu");
        playerRequest.setAge(26);
        playerRequest.setEmail("angie@gmail.com");
        playerRequest.setSex("F");

        return playerRequest;
    }

    public static List<Player> obtainPlayerList(){
        List<Player> listOfPlayers = new ArrayList<>();

        Player player0 = new Player(
                -1L,
                "Ash",
                "Ketchup",
                "ashup1997",
                15,
                "ash@gmail.com",
                "M"
        );

        Player player1 = new Player(
                -2L,
                "Penny",
                "Cassiopeia",
                "Cassiony",
                12,
                "penny@gmail.com",
                "F"
        );

        Player player2 = new Player(
                -3L,
                "Brock",
                "Takeshi",
                "takeck",
                17,
                "brock@gmail.com",
                "M"
        );

        listOfPlayers.add(player0);
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);

        return listOfPlayers;
    }


}
