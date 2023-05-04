package com.victorca.game_collection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


import java.util.UUID;

@Data
@Entity(name="Game")
@Table(name="GAME_TABLE")
public class Game {

    @Id
    @Column(name="gameId", updatable = false)
    private String gameId;
    @Column(name="gameTitle")
    private String gameTitle;
    @Column(name="playerCount")
    private String playerCount;
    @Column(name="playingTime")
    private String playingTime;

    public Game (String gameTitle){
        String id = UUID.randomUUID().toString();
        this.gameId = id;
        this.gameTitle = gameTitle;
    }

    public Game(String gameTitle, String playerCount, String playingTime){
        String id = UUID.randomUUID().toString();
        this.gameTitle = gameTitle;
        this.gameId = id;
        this.playerCount = playerCount;
        this.playingTime = playingTime;
    }
    public Game(){
        String id = UUID.randomUUID().toString();
        this.gameId = id;
    }
}
