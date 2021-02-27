package com.ironhack.pokemon.service.impl;

import com.ironhack.pokemon.controller.dtos.*;
import com.ironhack.pokemon.model.*;
import com.ironhack.pokemon.repository.*;
import com.ironhack.pokemon.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

import java.util.*;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamDTO createNewTeam(TeamDTO teamDTO) {
        Team team = new Team(teamDTO);
        teamRepository.save(team);
        return new TeamDTO(team);
    }

    public TeamDTO addNewMate(Long teamId, Long pokemonId) {
        Team ourTeam = checkTeam(teamId);

        if (ourTeam.getPokemonList().size() > 6){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The team " + teamId + " is full.");
        }
        List<Pokemon> mates = ourTeam.getPokemonList();
        mates.add(new Pokemon(pokemonId));
        ourTeam.setPokemonList(mates);
        teamRepository.save(ourTeam);
        return new TeamDTO(ourTeam);
    }

    public TeamDTO removeMate(Long teamId, Long pokemonId) {
        Team ourTeam = checkTeam(teamId);
        List<Pokemon> mates = ourTeam.getPokemonList();
        mates.remove(teamRepository.findByPokemonListPokedexId(pokemonId));
        ourTeam.setPokemonList(mates);
        teamRepository.save(ourTeam);
        return new TeamDTO(ourTeam);
    }

    public Team checkTeam(Long teamId){
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + teamId + " does not belong to any of our teams.");
        }
        return team.get();
    }
}
