package com.ironhack.pokemon.controller.dtos;

import com.ironhack.pokemon.model.*;
import com.sun.istack.*;

import java.util.*;

public class TeamDTO {

    private Long id;
    @NotNull
    private TrainerDTO trainerDTO;
    private List<Pokemon> pokemonList;

    public TeamDTO() {
    }

    public TeamDTO(Team team) {
        this.id = team.getTeamId();
        this.trainerDTO = new TrainerDTO(team.getTrainer());
        this.pokemonList = team.getPokemonList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainerDTO getTrainerDTO() {
        return trainerDTO;
    }

    public void setTrainerDTO(TrainerDTO trainerDTO) {
        this.trainerDTO = trainerDTO;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
