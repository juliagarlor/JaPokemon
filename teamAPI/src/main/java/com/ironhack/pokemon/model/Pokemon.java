package com.ironhack.pokemon.model;

import com.ironhack.pokemon.enums.*;

import javax.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pokedexId;

//    Constructor

    public Pokemon() {
    }

    public Pokemon(Long pokedexId) {
        this.pokedexId = pokedexId;
    }

//    Getters and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Long pokedexId) {
        this.pokedexId = pokedexId;
    }
}
