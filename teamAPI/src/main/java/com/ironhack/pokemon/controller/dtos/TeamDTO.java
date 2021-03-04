package com.ironhack.pokemon.controller.dtos;

import com.ironhack.pokemon.model.*;

import javax.validation.*;
import javax.validation.constraints.*;
import java.util.*;

public class TeamDTO {

    private Long id;
    @Valid
    private TrainerDTO trainer;
    @NotNull(message = "A team must have a pokemon list")
    private List<Pokemon> pokemonList;

    public TeamDTO() {
    }

    public TeamDTO(Team team) {
        this.id = team.getTeamId();
        this.trainer = new TrainerDTO(team.getTrainer());
        this.pokemonList = team.getPokemonList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainerDTO getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerDTO trainer) {
        this.trainer = trainer;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
