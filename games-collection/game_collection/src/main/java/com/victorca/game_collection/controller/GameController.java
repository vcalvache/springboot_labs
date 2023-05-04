package com.victorca.game_collection.controller;

import com.victorca.game_collection.service.ExpansionService;
import com.victorca.game_collection.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;
    @Autowired
    ExpansionService expansionService;

    @GetMapping("/")
    public String gameIndex(){
        return "games/games-index";
    }
}
