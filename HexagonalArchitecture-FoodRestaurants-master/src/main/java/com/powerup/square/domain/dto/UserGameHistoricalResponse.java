package com.powerup.square.domain.dto;

import com.powerup.square.domain.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserGameHistoricalResponse {

    private Integer hoursPlayed;

    private String gameName;

    private String playerName;

    private String username;
}
