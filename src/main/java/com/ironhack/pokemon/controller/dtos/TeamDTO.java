package com.ironhack.pokemon.controller.dtos;

import com.ironhack.pokemon.model.*;
import com.sun.istack.*;

import java.util.*;

public class TeamDTO {

    private Long id;
    @NotNull
    private Long trainerId;
    private List<Pokemon> pokemonList;

    public TeamDTO(Team team) {
        this.trainerId = team.getTrainer().getId();
        this.pokemonList = team.getPokemonList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
