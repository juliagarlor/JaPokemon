package com.ironhack.pokemon.model;

import com.ironhack.pokemon.enums.*;

import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    private Long pokedexId;

//    Constructor

    public Pokemon() {
    }

    public Pokemon(Long pokedexId) {
        this.pokedexId = pokedexId;
    }

//    Getters and Setter

    public Long getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Long pokedexId) {
        this.pokedexId = pokedexId;
    }
}
