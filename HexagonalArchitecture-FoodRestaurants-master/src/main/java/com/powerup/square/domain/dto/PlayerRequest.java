package com.powerup.square.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlayerRequest {

    @NotBlank(message = "firstName can't be empty")
    private String firstName;

    @NotBlank(message = "lastname can't be empty")
    private String lastname;

    @NotBlank(message = "username can't be empty")
    private String username;

    @NotNull(message = "age can't be empty")
    private Integer age;

    @NotBlank(message = "email can't be empty")
    @Email
    private String email;

    @NotBlank(message = "sex can't be empty, remember that it should be only one Character F/M")
    private String sex;
}
