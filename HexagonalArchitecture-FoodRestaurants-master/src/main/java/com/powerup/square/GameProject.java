package com.powerup.square;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class GameProject {

	public static void main(String[] args) {
		SpringApplication.run(GameProject.class, args);
	}

}
