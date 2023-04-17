package com.powerup.square.controller;


import com.powerup.square.domain.model.Game;
import com.powerup.square.domain.service.GameServiceHandler;
import com.powerup.square.domain.dto.GameRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameRestController {

    private final GameServiceHandler gameServiceHandler;
//    @Autowired
//    private GameServiceHandler gameServiceHandler;

    @Operation(summary = "Add a game")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Game created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @PostMapping("/create")
    public ResponseEntity<Void> saveGameEntity(@Validated @RequestBody GameRequest gameRequest){
        gameServiceHandler.saveGame(gameRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Requests a specific game by its name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Games displayed", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @GetMapping("/{gameName}")
    public ResponseEntity<Game> getAGameByTheName(@PathVariable String gameName){
        return ResponseEntity.status(HttpStatus.OK).body(gameServiceHandler.getGameByGameName(gameName));
    }

    @Operation(summary = "Requests all games registered")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Games displayed", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<Game>> getAllGamesEntity(){
        return ResponseEntity.status(HttpStatus.OK).body(gameServiceHandler.getAllGames());
    }

}
