package com.powerup.square.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GameRequest {

    @NotBlank(message = "gameName can't be empty")
    private String gameName;

    @NotBlank(message = "description can't be empty")
    private String description;

    @NotBlank(message = "dateLaunched can't be empty, and must have a format of yyyy-MM-dd")
    private String dateLaunched;

    @NotNull(message = "rateScore can't be empty")
    private Integer rateScore;
}
