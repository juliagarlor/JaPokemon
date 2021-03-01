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
@CrossOrigin(origins = "**", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class TrainerController implements ITrainerController {

    @Autowired
    private ITrainerService iTrainerService;

//    create a trainer and automatically create its team
    @PostMapping("/trainer")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDTO createNewTrainer(@RequestBody TrainerDTO trainerDTO){
        return iTrainerService.createNewTrainer(trainerDTO);
    }

//    get all trainers
    @CrossOrigin(origins = "http://localhost:4200")
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

//    Delete a trainer and automatically delete its team
    @DeleteMapping("/trainer/{id}")
    public void removeTrainer(@PathVariable Long id){
        iTrainerService.removeTrainer(id);
    }
}
