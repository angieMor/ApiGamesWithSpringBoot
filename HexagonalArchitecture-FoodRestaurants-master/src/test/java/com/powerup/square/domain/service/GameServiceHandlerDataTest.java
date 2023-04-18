package com.powerup.square.domain.service;

import com.powerup.square.domain.dto.GameRequest;
import com.powerup.square.domain.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameServiceHandlerDataTest {

    public static Game obtainGame(){
        return
                new Game(
              -1L,
              "Megaman",
                "Pixel platform game, you can shoot :)",
                "1998-05-05",
                5
        );
    }

    public static GameRequest obtainGameRequest(){
        GameRequest gameRequest = new GameRequest();

        gameRequest.setGameName("Megaman");
        gameRequest.setDescription("Pixel platform game, you can shoot :)");
        gameRequest.setDateLaunched("1998-05-05");
        gameRequest.setRateScore(5);

        return gameRequest;
    }

    public static List<Game> obtainListOfGames(){
        List<Game> listOfGames = new ArrayList<>();

        Game game0 = new Game(
                -1L,
                "Megaman",
                "Pixel platform game, you can shoot :)",
                "1998-05-05",
                5
        );

        Game game1 = new Game(
                -2L,
                "Castlevania Symphony Of the Night",
                "Pixel platform game, killing monster wit melee (Metroidvania)",
                "2001-05-05",
                5
        );

        Game game2 = new Game(
                -3L,
                "Castlevania Rondo of blood",
                "Pixel platform game, killing monster wit melee (Metroidvania)",
                "1998-05-05",
                5
        );

        listOfGames.add(game0);
        listOfGames.add(game1);
        listOfGames.add(game2);

        return listOfGames;
    }
}
