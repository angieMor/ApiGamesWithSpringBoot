package com.powerup.square.domain.model;


public class Game {

    private Long id;

    private String gameName;

    private String description;

    private String dateLaunched;

    private Integer rateScore;

    public Game(Long id, String gameName, String description, String dateLaunched, Integer rateScore) {
        this.id = id;
        this.gameName = gameName;
        this.description = description;
        this.dateLaunched = dateLaunched;
        this.rateScore = rateScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateLaunched() {
        return dateLaunched;
    }

    public void setDateLaunched(String dateLaunched) {
        this.dateLaunched = dateLaunched;
    }

    public Integer getRateScore() {
        return rateScore;
    }

    public void setRateScore(Integer rateScore) {
        this.rateScore = rateScore;
    }
}
