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

    public TrainerDTO createNewTrainer(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer(trainerDTO);
        trainerRepository.save(trainer);
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
}
