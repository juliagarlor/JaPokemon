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
    @Autowired
    private PokemonRepository pokemonRepository;

    public List<TeamDTO> getAllTeams() {
//        Get all teams and pass the information to a list of teamDTO
        List<Team> teams = teamRepository.findAll();
        List<TeamDTO> output = new ArrayList<>();
        for (Team t:teams){
            output.add(new TeamDTO(t));
        }
        return output;
    }

    public TeamDTO addNewMate(Long teamId, Long pokemonId) {
//        checking whether the team id is correct and this team has as 7 pokemon or less
        Team ourTeam = checkTeam(teamId);

        if (ourTeam.getPokemonList().size() > 6){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "The team " + teamId + " is full.");
        }
//        Register the new pokemon in the pokemon table
        Pokemon newMate = new Pokemon(pokemonId);
        pokemonRepository.save(newMate);
//        add it to the team
        List<Pokemon> mates = ourTeam.getPokemonList();
        mates.add(newMate);
        ourTeam.setPokemonList(mates);
//        save the update
        teamRepository.save(ourTeam);
        return new TeamDTO(ourTeam);
    }

    public TeamDTO removeMate(Long teamId, Long pokemonId) {
//        check whether the team id is correct
        Team ourTeam = checkTeam(teamId);
//        get the list of pokemon of this team
        List<Pokemon> mates = ourTeam.getPokemonList();
//        look for the pokemon we want to remove in the repository. If the id is wrong, throw a status
        Optional<Pokemon> pokemonToRemove = pokemonRepository.findById(pokemonId);
        if (pokemonToRemove.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No pokemon registered with id " + pokemonId);
        }
//        Remove this pokemon from the list and save the new list and the update in this team
        mates.remove(pokemonToRemove.get());
        ourTeam.setPokemonList(mates);
        teamRepository.save(ourTeam);
//        remove this pokemon from the table
        pokemonRepository.deleteById(pokemonId);
        return new TeamDTO(ourTeam);
    }

    public Team checkTeam(Long teamId){
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id " + teamId + " does not belong to any of our teams.");
        }
        return team.get();
    }

    public List<TeamDTO> checkTeamByName(String name) {
        List<Team> teamList = teamRepository.findByTrainerName(name);
        List<TeamDTO> teamDTOList = new ArrayList<>();

        if (teamList.size() != 0){
            for(Team team: teamList){
                teamDTOList.add(new TeamDTO(team));
            }
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not a trainer with name: " + name);
        }
        return teamDTOList;
    }
}
