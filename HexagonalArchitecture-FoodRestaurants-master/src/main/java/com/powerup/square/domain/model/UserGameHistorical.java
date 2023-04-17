package com.powerup.square.domain.model;

public class UserGameHistorical {

    private Long id;

    private Integer hoursPlayed;

    private Game game;

    private Player player;

    public UserGameHistorical(Long id, Integer hoursPlayed, Game game, Player player) {
        this.id = id;
        this.hoursPlayed = hoursPlayed;
        this.game = game;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(Integer hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
