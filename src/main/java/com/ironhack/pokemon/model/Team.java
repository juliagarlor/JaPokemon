package com.ironhack.pokemon.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    private Long trainerId;
    private List<Pokemon> pokemonList;

//    Constructor
    public Team() {
    }

    public Team(Long trainerId, List<Pokemon> pokemonList) {
        this.trainerId = trainerId;
        this.pokemonList = pokemonList;
    }

//    Getters and Setters
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
