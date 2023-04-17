package com.powerup.square.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserGameHistoricalRequest {

    @NotBlank(message = "firstName field can't be empty")
    private String firstName;

    @NotBlank(message = "gameName field can't be empty")
    private String gameName;

    @NotNull(message = "hours field can't be empty")
    private Integer hours;
}
