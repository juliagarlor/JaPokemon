package com.ironhack.pokemon.repository;

import com.ironhack.pokemon.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Pokemon findByPokemonListPokedexId(Long id);
}
