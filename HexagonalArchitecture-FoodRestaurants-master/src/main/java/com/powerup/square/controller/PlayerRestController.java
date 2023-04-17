package com.powerup.square.controller;

import com.powerup.square.domain.model.Player;
import com.powerup.square.domain.service.PlayerServiceHandler;
import com.powerup.square.domain.dto.PlayerRequest;
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
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerRestController {

    private final PlayerServiceHandler playerServiceHandler;

    @Operation(summary = "Add a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @PostMapping("/create")
    public ResponseEntity<Void> savePlayerEntity(@Validated @RequestBody PlayerRequest playerRequest){
        playerServiceHandler.savePlayer(playerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Requests all players registered")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Players displayed", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method not allowed", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayersEntity(){
        return ResponseEntity.status(HttpStatus.OK).body(playerServiceHandler.getAllPlayers());
    }

}
