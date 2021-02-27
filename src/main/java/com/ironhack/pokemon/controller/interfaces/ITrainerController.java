package com.ironhack.pokemon.controller.interfaces;

import com.ironhack.pokemon.controller.dtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface ITrainerController {
    TrainerDTO createNewTrainer(TrainerDTO trainerDTO);
    TrainerDTO getTrainerById(Long id);
    List<TrainerDTO> getAllTrainers();
}
