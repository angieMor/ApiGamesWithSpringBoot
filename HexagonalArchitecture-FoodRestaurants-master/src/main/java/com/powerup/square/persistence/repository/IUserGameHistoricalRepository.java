package com.powerup.square.persistence.repository;

import com.powerup.square.persistence.entity.UserGameHistoricalEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserGameHistoricalRepository extends JpaRepository<UserGameHistoricalEntity, Long> {

    UserGameHistoricalEntity findByGameIdAndPlayerId(Long gameId, Long playerId);

    @Query(value = "SELECT * " +
                   "FROM user_games_historical " +
                   "WHERE game_id = :gameId " +
                   "ORDER BY hours_played DESC LIMIT 10",
            nativeQuery = true)
    List<UserGameHistoricalEntity> findTop10OfGameByHoursPlayedDesc(@Param("gameId") Long gameId);

    @Query(value= "SELECT * " +
                  "FROM user_games_historical "+
                  "WHERE player_id = :playerId " +
                  "ORDER BY hours_played DESC LIMIT 10",
            nativeQuery = true)
    List<UserGameHistoricalEntity> findTop10OfGamesPlayedByPlayer(@Param("playerId") Long playerId);

    List<UserGameHistoricalEntity> findTop10ByOrderByHoursPlayedDesc();
}
