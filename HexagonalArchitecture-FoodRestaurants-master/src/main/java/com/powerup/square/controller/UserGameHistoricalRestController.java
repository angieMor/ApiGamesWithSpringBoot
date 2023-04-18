package com.powerup.square.controller;

import com.powerup.square.domain.service.UserGameHistoricalServiceHandler;
import com.powerup.square.domain.dto.UserGameHistoricalRequest;
import com.powerup.square.domain.dto.UserGameHistoricalResponse;
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
@RequestMapping("/historical")
@RequiredArgsConstructor
public class UserGameHistoricalRestController {

    private final UserGameHistoricalServiceHandler userGameHistoricalServiceHandler;

    @Operation(summary = "Add hours to the game played by the player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hours added to the game played by the player", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @PutMapping("/add/hours")
    public ResponseEntity<Void> addHoursOfGameForAPlayerEntity(
            @Validated @RequestBody UserGameHistoricalRequest userGameHistoricalRequest){
        userGameHistoricalServiceHandler.addHoursOfGameForAPlayer(userGameHistoricalRequest);
        return new ResponseEntity("Hours added to the game and firstName of the player given", HttpStatus.OK);
    }

    @Operation(summary = "Edit/Replace hours to the game played by the player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hours edited/replaced for the game played by the player", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @PutMapping("/set/hours")
    public ResponseEntity<Void> editHoursOfGameForAPlayerEntity(
            @Validated @RequestBody UserGameHistoricalRequest userGameHistoricalRequest){
        userGameHistoricalServiceHandler.editHoursOfGameForAPlayer(userGameHistoricalRequest);
        return new ResponseEntity("Hours replaced for the game and firstName of the player given", HttpStatus.OK);
    }

    @Operation(summary = "Hours to reduce the hours of the game played by the player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hours reduced to the game played by the player", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @PutMapping("/reduce/hours")
    public ResponseEntity<Void> deleteHoursToGameDependingOnPlayerEntity(
            @Validated @RequestBody UserGameHistoricalRequest userGameHistoricalRequest){
        userGameHistoricalServiceHandler.deleteHoursToGameForAPlayer(userGameHistoricalRequest);
        return new ResponseEntity("Hours reduced to the game and firstName of the player given", HttpStatus.OK);
    }

    @Operation(summary = "Top 10 by most played games in 'x' game")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hours reduced to the game played by the player", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @GetMapping("/top10/game/{gameName}")
    public ResponseEntity<List<UserGameHistoricalResponse>> top10OfPlayersWhichPlayedALotAGameEntity(
            @PathVariable String gameName){
        return ResponseEntity.status(HttpStatus.OK).body(userGameHistoricalServiceHandler.getTop10OfPlayersByGame(gameName));

    }

    @Operation(summary = "Top 10, most played games by player's first name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hours reduced to the game played by the player", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @GetMapping("/top10/player/{playerFirstName}")
    public ResponseEntity<List<UserGameHistoricalResponse>> top10OfGamesPlayedByPlayerEntity(
            @PathVariable String playerFirstName){
        return ResponseEntity.status(HttpStatus.OK).body(userGameHistoricalServiceHandler.getTop10OfGamesPlayedByPlayer(playerFirstName));

    }

    @Operation(summary = "Top 10, most played games by player's first name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hours reduced to the game played by the player", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @GetMapping("/top10")
    public ResponseEntity<List<UserGameHistoricalResponse>> top10GeneralEntity(){
        return ResponseEntity.status(HttpStatus.OK).body(userGameHistoricalServiceHandler.getGeneralTop10());

    }
}
