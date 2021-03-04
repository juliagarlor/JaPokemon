package com.ironhack.pokemon.repository;

import com.ironhack.pokemon.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
