package com.ironhack.pokemon.service.interfaces;

import com.ironhack.pokemon.controller.dtos.*;

import java.util.*;

public interface ITrainerService {
    TrainerDTO createNewTrainer(TrainerDTO trainerDTO);
    TrainerDTO getTrainerById(Long id);
    List<TrainerDTO> getAllTrainers();
}
