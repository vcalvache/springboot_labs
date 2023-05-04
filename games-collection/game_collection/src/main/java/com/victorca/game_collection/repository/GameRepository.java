package com.victorca.game_collection.repository;

import com.victorca.game_collection.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, String> {
    Optional<Game> findByGameId(String gameId);
}
