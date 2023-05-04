package com.victorca.game_collection.controller;

import com.victorca.game_collection.service.ExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/expansion")
public class ExpansionController {

    @Autowired
    ExpansionService expansionService;

    @GetMapping("/")
    public String expansionIndex(){
        return "expansion/expansion-index";
    }
}
