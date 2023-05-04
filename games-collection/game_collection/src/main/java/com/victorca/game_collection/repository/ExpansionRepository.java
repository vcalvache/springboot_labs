package com.victorca.game_collection.repository;

import com.victorca.game_collection.model.Expansion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpansionRepository extends CrudRepository<Expansion, String> {
    Optional<Expansion> findByExpansionId(String expansionId);
}
