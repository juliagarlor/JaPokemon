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
public class TrainerService implements ITrainerService {

    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PokemonRepository pokemonRepository;

    public TrainerDTO createNewTrainer(TrainerDTO trainerDTO) {
//        When a trainer is created, its team is automatically created with him with an empty list of pokemon
        Trainer trainer = new Trainer(trainerDTO);
//        Saving new trainer
        trainerRepository.save(trainer);
        List<Pokemon> mates = new ArrayList<>();
        Team newTeam = new Team(trainer, mates);
//        Saving new team
        teamRepository.save(newTeam);
        return new TrainerDTO(trainer);
    }

    public TrainerDTO getTrainerById(Long id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);

        if (trainer.isPresent()){
            return new TrainerDTO(trainer.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not a trainer with id " + id);
        }
    }

    public List<TrainerDTO> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        List<TrainerDTO> output = new ArrayList<>();
        for(Trainer t:trainers){
            output.add(new TrainerDTO(t));
        }
        return output;
    }

    public void removeTrainer(Long id) {
//        When removing a trainer, remove its team. Check if it is a correct trainer id
        Optional<Trainer> trainer = trainerRepository.findById(id);
        if (trainer.isPresent()){
//            find the team by trainer id, remove the team and remove the trainer
            Team teamToRemove = teamRepository.findByTrainerId(id);
//            Before removing the team, remove the pokemon from the pokemon table and the list of this team
            List<Pokemon> pokemonsToRemove = teamToRemove.getPokemonList();
            teamToRemove.setPokemonList(new ArrayList<>());
            pokemonRepository.deleteAll(pokemonsToRemove);
            teamRepository.delete(teamToRemove);
            trainerRepository.delete(trainer.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not a trainer with id " + id);
        }
    }
}
