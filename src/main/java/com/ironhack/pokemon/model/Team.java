package com.ironhack.pokemon.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    @OneToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToMany
    @JoinTable(
            name = "pokemon_in_team",
            joinColumns = { @JoinColumn(name = "team_id") },
            inverseJoinColumns = { @JoinColumn(name = "pokedex_id") }
    )
    private List<Pokemon> pokemonList;

//    Constructor
    public Team() {
    }

    public Team(Trainer trainer, List<Pokemon> pokemonList) {
        this.trainer = trainer;
        this.pokemonList = pokemonList;
    }

    //    Getters and Setters
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
