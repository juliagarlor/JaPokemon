package com.ironhack.pokemon.repository;

import com.ironhack.pokemon.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByTrainerId(Long id);
    List<Team> findByTrainerName(String name);
}
