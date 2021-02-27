package com.ironhack.pokemon.controller.impl;

import com.ironhack.pokemon.controller.dtos.*;
import com.ironhack.pokemon.controller.interfaces.*;
import com.ironhack.pokemon.model.*;
import com.ironhack.pokemon.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TrainerController implements ITrainerController {

    @Autowired
    private ITrainerService iTrainerService;

//    ruta para registrar un entrenador
    @PostMapping("/trainer")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDTO createNewTrainer(@RequestBody TrainerDTO trainerDTO){
        return iTrainerService.createNewTrainer(trainerDTO);
    }

//    get all trainers
    @GetMapping("/trainers")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainerDTO> getAllTrainers(){
        return iTrainerService.getAllTrainers();
    }

//    get trainers by id. No sé si vamos a necesitar esta, pero si no, al final revisamos y limpiamos
    @GetMapping("/trainer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainerDTO getTrainerById(@PathVariable Long id){
        return iTrainerService.getTrainerById(id);
    }

    //ruta para borrar trainer y al mismo tiempo borrar el equipo

}
