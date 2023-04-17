package com.powerup.square.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "game_name")
    private String gameName;

    private String description;

    @Column(name = "date_launched")
    private String dateLaunched;

    @Column(name = "rate_score")
    private Integer rateScore;
}
