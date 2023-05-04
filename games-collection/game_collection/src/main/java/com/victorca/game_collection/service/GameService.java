package com.victorca.game_collection.service;

import com.victorca.game_collection.model.Game;
import com.victorca.game_collection.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;
    public Iterable<Game> getAllGames() {
            return gameRepository.findAll();
    }
    public boolean saveGameToDB(Game game){
        if (gameRepository.findById(game.getGameId()).isPresent()){
            return false;
        }
        gameRepository.save(game);
        return true;
    }

    public Game getById(String gameID) {
        Optional<Game> gameFromDB = gameRepository.findById(gameID);
        if (gameFromDB.isPresent()) {
            return gameFromDB.get();
        }
            return null;
    }

    public Game getByTitle(String gameTitle){
        Optional<Game> gameFromDB = gameRepository.findById(gameTitle);
        if (gameFromDB.isPresent()){
            return gameFromDB.get();
        }
        return null;
    }

    public boolean deleteGame(Game game){
        if (gameRepository.findById(game.getGameId()).isPresent()){
            gameRepository.delete(game);
            return true;
        }
        return false;
    }

    public boolean updateGame(Game updatedGame){
        if(gameRepository.existsById(updatedGame.getGameId())){
            Game gameFromDB = gameRepository.findById(updatedGame.getGameId()).get();
            if (gameFromDB.getGameTitle() != updatedGame.getGameTitle()){
                gameFromDB.setGameTitle(updatedGame.getGameTitle());
            }
            if (gameFromDB.getPlayerCount()!= updatedGame.getPlayerCount()){
                gameFromDB.setPlayerCount(updatedGame.getPlayerCount());
            }
            if (gameFromDB.getPlayingTime()!= updatedGame.getPlayingTime()){
                gameFromDB.setPlayingTime(updatedGame.getPlayingTime());
            }

            gameRepository.save(gameFromDB);
            return true;
            }
            return false;
        }

    // TODO: Add expansion method
}

