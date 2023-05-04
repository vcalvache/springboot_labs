package com.victorca.game_collection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name="Expansion")
@Table(name="EXPANSION_TABLE")
public class Expansion {

    @Id
    @Column(name="expansionId", updatable = false)
    private String expansionId;
    @Column(name="expansionTitle")
    private String expansionTitle;

    public Expansion(String expansionTitle){
        String id = UUID.randomUUID().toString();
        this.expansionId = id;
        this.expansionTitle = expansionTitle;
    }

    public Expansion(){
        String id = UUID.randomUUID().toString();
        this.expansionId = id;
    }
}
