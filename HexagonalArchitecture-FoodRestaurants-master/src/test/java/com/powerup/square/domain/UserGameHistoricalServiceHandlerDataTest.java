package com.powerup.square.domain;

import com.powerup.square.domain.dto.UserGameHistoricalRequest;
import com.powerup.square.domain.dto.UserGameHistoricalResponse;
import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.model.UserGameHistorical;

import java.util.ArrayList;
import java.util.List;

public class UserGameHistoricalServiceHandlerDataTest {

    public static UserGameHistorical obtainUserGameHistorical(){
        return new UserGameHistorical(
                -1L,
                2,
                new Game(
                        -1L,
                        "Megaman",
                        "Pixel platform game, you can shoot :)",
                        "1998-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Angie",
                        "Moreno",
                        "AngieMoruwu",
                        26,
                        "angie@gmail.com",
                        "F"
                )
        );
    }

    public static UserGameHistoricalRequest obtainUserGameHistoricalRequest(){
        UserGameHistoricalRequest userGameHistoricalRequest = new UserGameHistoricalRequest();

        userGameHistoricalRequest.setFirstName("Angie");
        userGameHistoricalRequest.setGameName("Megaman");
        userGameHistoricalRequest.setHours(10);

        return userGameHistoricalRequest;
    }

    public static List<UserGameHistorical> obtainListOfUserGameHistoricalForTop10ByGame(){
        List<UserGameHistorical> listOfUserGameHistorical = new ArrayList<>();

        UserGameHistorical response0 = new UserGameHistorical(
                -1L,
                100,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response1 = new UserGameHistorical(
                -2L,
                98,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -2L,
                        "Angie",
                        "Moreno",
                        "AngieMoruwu",
                        26,
                        "angie@gmail.com",
                        "F"
                )

        );

        UserGameHistorical response2 = new UserGameHistorical(
                -3L,
                95,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -3L,
                        "Melisa",
                        "Mejia",
                        "melija96",
                        26,
                        "melisa@gmail.com",
                        "F"
                )

        );

        UserGameHistorical response3 = new UserGameHistorical(
                -4L,
                90,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -4L,
                        "Jose",
                        "Mendoza",
                        "jomen4",
                        26,
                        "jose@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response4 = new UserGameHistorical(
                -5L,
                85,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -6L,
                        "Armando",
                        "Mendoza",
                        "arma40",
                        26,
                        "armando@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response5 = new UserGameHistorical(
                -6L,
                80,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -7L,
                        "Pepito",
                        "Mendoza",
                        "pedoza26",
                        26,
                        "pepito@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response6 = new UserGameHistorical(
                -7L,
                75,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -8L,
                        "Josepo",
                        "Mendoza",
                        "jodoza226",
                        26,
                        "jodoza@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response7 = new UserGameHistorical(
                -8L,
                70,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -9L,
                        "Ariel",
                        "Mendoza",
                        "arieloza",
                        26,
                        "ariel@gmail.com",
                        "F"
                )

        );

        UserGameHistorical response8 = new UserGameHistorical(
                -9L,
                65,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -9L,
                        "Laura",
                        "Mendoza",
                        "laureloza",
                        26,
                        "laura@gmail.com",
                        "F"
                )

        );

        UserGameHistorical response9 = new UserGameHistorical(
                -10L,
                60,
                new Game(
                        -3L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -10L,
                        "Sofia",
                        "Mendoza",
                        "sofiloza",
                        26,
                        "sofia@gmail.com",
                        "F"
                )

        );


        listOfUserGameHistorical.add(response0);
        listOfUserGameHistorical.add(response1);
        listOfUserGameHistorical.add(response2);
        listOfUserGameHistorical.add(response3);
        listOfUserGameHistorical.add(response4);
        listOfUserGameHistorical.add(response5);
        listOfUserGameHistorical.add(response6);
        listOfUserGameHistorical.add(response7);
        listOfUserGameHistorical.add(response8);
        listOfUserGameHistorical.add(response9);

        return listOfUserGameHistorical;
    }

    public static List<UserGameHistoricalResponse> obtainListOfUserGameHistoricalResponseForTop10ByGame(){
        List<UserGameHistoricalResponse> listOfUserGameHistoricalResponse = new ArrayList<>();

        UserGameHistoricalResponse response0 = new UserGameHistoricalResponse(
                100,
                "Shovel Knight",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response1 = new UserGameHistoricalResponse(
                98,
                "Shovel Knight",
                "Angie",
                "AngieMoruwu"
        );

        UserGameHistoricalResponse response2 = new UserGameHistoricalResponse(
                95,
                "Shovel Knight",
                "Melisa",
                "melija96"
        );

        UserGameHistoricalResponse response3 = new UserGameHistoricalResponse(
                90,
                "Shovel Knight",
                "Jose",
                "jomen4"
        );

        UserGameHistoricalResponse response4 = new UserGameHistoricalResponse(
                89,
                "Shovel Knight",
                "Armando",
                "arma40"
        );

        UserGameHistoricalResponse response5 = new UserGameHistoricalResponse(
                80,
                "Shovel Knight",
                "Pepito",
                "pedoza26"
        );

        UserGameHistoricalResponse response6 = new UserGameHistoricalResponse(
                75,
                "Shovel Knight",
                "Josepo",
                "jodoza226"
        );

        UserGameHistoricalResponse response7 = new UserGameHistoricalResponse(
                70,
                "Shovel Knight",
                "Ariel",
                "arieloza"
        );

        UserGameHistoricalResponse response8 = new UserGameHistoricalResponse(
                70,
                "Shovel Knight",
                "Laura",
                "lauraloza"
        );

        UserGameHistoricalResponse response9 = new UserGameHistoricalResponse(
                65,
                "Shovel Knight",
                "Sofia",
                "sofiloza"
        );


        listOfUserGameHistoricalResponse.add(response0);
        listOfUserGameHistoricalResponse.add(response1);
        listOfUserGameHistoricalResponse.add(response2);
        listOfUserGameHistoricalResponse.add(response3);
        listOfUserGameHistoricalResponse.add(response4);
        listOfUserGameHistoricalResponse.add(response5);
        listOfUserGameHistoricalResponse.add(response6);
        listOfUserGameHistoricalResponse.add(response7);
        listOfUserGameHistoricalResponse.add(response8);
        listOfUserGameHistoricalResponse.add(response9);


        return listOfUserGameHistoricalResponse;
    }

    public static List<UserGameHistorical> obtainListOfUserGameHistoricalForTop10ByPlayer(){
        List<UserGameHistorical> listOfUserGameHistorical = new ArrayList<>();

        UserGameHistorical response0 = new UserGameHistorical(
                -1L,
                100,
                new Game(
                        -1L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response1 = new UserGameHistorical(
                -2L,
                98,
                new Game(
                        -2L,
                        "Celeste",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response2 = new UserGameHistorical(
                -3L,
                95,
                new Game(
                        -3L,
                        "Castlevania Symphony of the Night",
                        "Pixel platform game",
                        "2001-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response3 = new UserGameHistorical(
                -4L,
                90,
                new Game(
                        -4L,
                        "Castlevania Rondo of Blood",
                        "Pixel platform game",
                        "1998-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response4 = new UserGameHistorical(
                -5L,
                85,
                new Game(
                        -5L,
                        "Super mario bros 3",
                        "Pixel platform game",
                        "1996-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response5 = new UserGameHistorical(
                -6L,
                80,
                new Game(
                        -6L,
                        "Super Mario World",
                        "Pixel platform game",
                        "2001-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response6 = new UserGameHistorical(
                -7L,
                75,
                new Game(
                        -7L,
                        "Super Mario Bros",
                        "Pixel platform game",
                        "1995-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response7 = new UserGameHistorical(
                -8L,
                70,
                new Game(
                        -8L,
                        "Blasphemous",
                        "Pixel game, kill stuff at melee",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response8 = new UserGameHistorical(
                -9L,
                65,
                new Game(
                        -9L,
                        "Deedlith in wonder laberynth",
                        "Pixel melee, platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response9 = new UserGameHistorical(
                -10L,
                60,
                new Game(
                        -10L,
                        "Valfaris",
                        "Pixel melee, platform game",
                        "2019-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );


        listOfUserGameHistorical.add(response0);
        listOfUserGameHistorical.add(response1);
        listOfUserGameHistorical.add(response2);
        listOfUserGameHistorical.add(response3);
        listOfUserGameHistorical.add(response4);
        listOfUserGameHistorical.add(response5);
        listOfUserGameHistorical.add(response6);
        listOfUserGameHistorical.add(response7);
        listOfUserGameHistorical.add(response8);
        listOfUserGameHistorical.add(response9);

        return listOfUserGameHistorical;
    }

    public static List<UserGameHistoricalResponse> obtainListOfUserGameHistoricalResponseForTop10ByPlayer(){
        List<UserGameHistoricalResponse> listOfUserGameHistoricalResponse = new ArrayList<>();

        UserGameHistoricalResponse response0 = new UserGameHistoricalResponse(
                100,
                "Shovel Knight",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response1 = new UserGameHistoricalResponse(
                98,
                "Celeste",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response2 = new UserGameHistoricalResponse(
                95,
                "Castlevania Symphony of the Night",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response3 = new UserGameHistoricalResponse(
                90,
                "Castlevania Rondo of blood",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response4 = new UserGameHistoricalResponse(
                89,
                "Super mario bros 3",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response5 = new UserGameHistoricalResponse(
                80,
                "Super Mario World",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response6 = new UserGameHistoricalResponse(
                75,
                "Super Mario Bros",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response7 = new UserGameHistoricalResponse(
                70,
                "Blasphemous",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response8 = new UserGameHistoricalResponse(
                65,
                "Deedlith in wonder laberynth",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response9 = new UserGameHistoricalResponse(
                60,
                "Valfaris",
                "Diego",
                "DiegoAAA"
        );


        listOfUserGameHistoricalResponse.add(response0);
        listOfUserGameHistoricalResponse.add(response1);
        listOfUserGameHistoricalResponse.add(response2);
        listOfUserGameHistoricalResponse.add(response3);
        listOfUserGameHistoricalResponse.add(response4);
        listOfUserGameHistoricalResponse.add(response5);
        listOfUserGameHistoricalResponse.add(response6);
        listOfUserGameHistoricalResponse.add(response7);
        listOfUserGameHistoricalResponse.add(response8);
        listOfUserGameHistoricalResponse.add(response9);


        return listOfUserGameHistoricalResponse;
    }

    public static List<UserGameHistorical> obtainListOfUserGameHistoricalGeneralTop10(){
        List<UserGameHistorical> listOfUserGameHistorical = new ArrayList<>();

        UserGameHistorical response0 = new UserGameHistorical(
                -1L,
                100,
                new Game(
                        -1L,
                        "Shovel Knight",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -1L,
                        "Diego",
                        "Alvarez",
                        "DiegoAAA",
                        26,
                        "diego@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response1 = new UserGameHistorical(
                -2L,
                98,
                new Game(
                        -2L,
                        "Celeste",
                        "Pixel platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -2L,
                        "Angie",
                        "Moreno",
                        "AngieMoruwu",
                        26,
                        "angie@gmail.com",
                        "F"
                )

        );

        UserGameHistorical response2 = new UserGameHistorical(
                -3L,
                95,
                new Game(
                        -3L,
                        "Castlevania Symphony of the Night",
                        "Pixel platform game",
                        "2001-05-05",
                        5
                ),
                new Player(
                        -3L,
                        "Melisa",
                        "Mejia",
                        "melija96",
                        26,
                        "melisa@gmail.com",
                        "F"
                )

        );

        UserGameHistorical response3 = new UserGameHistorical(
                -4L,
                90,
                new Game(
                        -4L,
                        "Castlevania Rondo of Blood",
                        "Pixel platform game",
                        "1998-05-05",
                        5
                ),
                new Player(
                        -4L,
                        "Jose",
                        "Mendoza",
                        "jomen4",
                        26,
                        "jose@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response4 = new UserGameHistorical(
                -5L,
                85,
                new Game(
                        -5L,
                        "Super mario bros 3",
                        "Pixel platform game",
                        "1996-05-05",
                        5
                ),
                new Player(
                        -6L,
                        "Armando",
                        "Mendoza",
                        "arma40",
                        26,
                        "armando@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response5 = new UserGameHistorical(
                -6L,
                80,
                new Game(
                        -6L,
                        "Super Mario World",
                        "Pixel platform game",
                        "2001-05-05",
                        5
                ),
                new Player(
                        -7L,
                        "Pepito",
                        "Mendoza",
                        "pedoza26",
                        26,
                        "pepito@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response6 = new UserGameHistorical(
                -7L,
                75,
                new Game(
                        -7L,
                        "Super Mario Bros",
                        "Pixel platform game",
                        "1995-05-05",
                        5
                ),
                new Player(
                        -8L,
                        "Josepo",
                        "Mendoza",
                        "jodoza226",
                        26,
                        "jodoza@gmail.com",
                        "M"
                )

        );

        UserGameHistorical response7 = new UserGameHistorical(
                -8L,
                70,
                new Game(
                        -8L,
                        "Blasphemous",
                        "Pixel game, kill stuff at melee",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -9L,
                        "Ariel",
                        "Mendoza",
                        "arieloza",
                        26,
                        "ariel@gmail.com",
                        "F"
                )

        );

        UserGameHistorical response8 = new UserGameHistorical(
                -9L,
                65,
                new Game(
                        -9L,
                        "Deedlith in wonder laberynth",
                        "Pixel melee, platform game",
                        "2017-05-05",
                        5
                ),
                new Player(
                        -9L,
                        "Laura",
                        "Mendoza",
                        "laureloza",
                        26,
                        "laura@gmail.com",
                        "F"
                )


        );

        UserGameHistorical response9 = new UserGameHistorical(
                -10L,
                60,
                new Game(
                        -10L,
                        "Valfaris",
                        "Pixel melee, platform game",
                        "2019-05-05",
                        5
                ),
                new Player(
                        -10L,
                        "Sofia",
                        "Mendoza",
                        "sofiloza",
                        26,
                        "sofia@gmail.com",
                        "F"
                )

        );


        listOfUserGameHistorical.add(response0);
        listOfUserGameHistorical.add(response1);
        listOfUserGameHistorical.add(response2);
        listOfUserGameHistorical.add(response3);
        listOfUserGameHistorical.add(response4);
        listOfUserGameHistorical.add(response5);
        listOfUserGameHistorical.add(response6);
        listOfUserGameHistorical.add(response7);
        listOfUserGameHistorical.add(response8);
        listOfUserGameHistorical.add(response9);

        return listOfUserGameHistorical;
    }

    public static List<UserGameHistoricalResponse> obtainListOfUserGameHistoricalResponseGeneralTop10(){
        List<UserGameHistoricalResponse> listOfUserGameHistoricalResponse = new ArrayList<>();

        UserGameHistoricalResponse response0 = new UserGameHistoricalResponse(
                100,
                "Shovel Knight",
                "Diego",
                "DiegoAAA"
        );

        UserGameHistoricalResponse response1 = new UserGameHistoricalResponse(
                98,
                "Celeste",
                "Angie",
                "AngieMoruwu"
        );

        UserGameHistoricalResponse response2 = new UserGameHistoricalResponse(
                95,
                "Castlevania Symphony of the Night",
                "Melissa",
                "melija96"
        );

        UserGameHistoricalResponse response3 = new UserGameHistoricalResponse(
                90,
                "Castlevania Rondo of blood",
                "Jose",
                "jomen4"
        );

        UserGameHistoricalResponse response4 = new UserGameHistoricalResponse(
                89,
                "Super mario bros 3",
                "Armando",
                "arma40"
        );

        UserGameHistoricalResponse response5 = new UserGameHistoricalResponse(
                80,
                "Super Mario World",
                "Pepito",
                "pedoza26"
        );

        UserGameHistoricalResponse response6 = new UserGameHistoricalResponse(
                75,
                "Super Mario Bros",
                "Josepo",
                "jodoza226"
        );

        UserGameHistoricalResponse response7 = new UserGameHistoricalResponse(
                70,
                "Blasphemous",
                "Ariel",
                "arieloza"
        );

        UserGameHistoricalResponse response8 = new UserGameHistoricalResponse(
                65,
                "Deedlith in wonder laberynth",
                "Laura",
                "laureloza"
        );

        UserGameHistoricalResponse response9 = new UserGameHistoricalResponse(
                60,
                "Valfaris",
                "Sofia",
                "sofiloza"
        );


        listOfUserGameHistoricalResponse.add(response0);
        listOfUserGameHistoricalResponse.add(response1);
        listOfUserGameHistoricalResponse.add(response2);
        listOfUserGameHistoricalResponse.add(response3);
        listOfUserGameHistoricalResponse.add(response4);
        listOfUserGameHistoricalResponse.add(response5);
        listOfUserGameHistoricalResponse.add(response6);
        listOfUserGameHistoricalResponse.add(response7);
        listOfUserGameHistoricalResponse.add(response8);
        listOfUserGameHistoricalResponse.add(response9);


        return listOfUserGameHistoricalResponse;
    }

}
