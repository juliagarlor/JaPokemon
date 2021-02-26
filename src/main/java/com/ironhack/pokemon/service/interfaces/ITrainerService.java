package com.ironhack.pokemon.service.interfaces;

import com.ironhack.pokemon.controller.dtos.*;

public interface ITrainerService {
    TrainerDTO createNewTrainer(TrainerDTO trainerDTO);
    TrainerDTO getTrainerById(Long id);
}
