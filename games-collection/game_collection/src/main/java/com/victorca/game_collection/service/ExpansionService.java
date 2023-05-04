package com.victorca.game_collection.service;

import com.victorca.game_collection.model.Expansion;
import com.victorca.game_collection.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpansionService {

    @Autowired
    ExpansionRepository expansionRepository;
    public Iterable<Expansion> getAllExpansions() {
        return expansionRepository.findAll();
    }
    public boolean saveExpansionToDB(Expansion expansion){
        if (expansionRepository.findById(expansion.getExpansionId()).isPresent()){
            return false;
        }
        expansionRepository.save(expansion);
        return true;
    }

    public Expansion getById(String expansionID) {
        Optional<Expansion> expansionFromDB = expansionRepository.findById(expansionID);
        if (expansionFromDB.isPresent()) {
            return expansionFromDB.get();
        }
        return null;
    }
    public boolean deleteExpansion(Expansion expansion){
        if (expansionRepository.findById(expansion.getExpansionId()).isPresent()){
            expansionRepository.delete(expansion);
            return true;
        }
        return false;
    }

    public boolean updateExpansion(Expansion updatedExpansion){
        if(expansionRepository.existsById(updatedExpansion.getExpansionId())){
            Expansion expansionFromDB = expansionRepository.findById(updatedExpansion.getExpansionId()).get();
            if (expansionFromDB.getExpansionTitle() != updatedExpansion.getExpansionTitle()){
                expansionFromDB.setExpansionTitle(updatedExpansion.getExpansionTitle());
            }
            expansionRepository.save(expansionFromDB);
            return true;
        }
        return false;
    }
}

