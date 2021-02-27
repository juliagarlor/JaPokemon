package com.ironhack.pokemon.controller.impl;

import com.ironhack.pokemon.controller.dtos.*;
import com.ironhack.pokemon.controller.interfaces.*;
import com.ironhack.pokemon.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController implements ITeamController {

    @Autowired
    private ITeamService teamService;

//    ruta para crear un equipo
    @PostMapping("/team")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createNewTeam(@RequestBody TeamDTO teamDTO){
        return teamService.createNewTeam(teamDTO);
    }

//    Ruta para incluir un pokemon en un equipo
    @PatchMapping("/add/{teamId}/team-mate")
    @ResponseStatus(HttpStatus.OK)
    public TeamDTO addNewMate(@PathVariable Long teamId, @RequestBody Long pokemonId){
        return teamService.addNewMate(teamId, pokemonId);
    }

//    Ruta para borrar un pokemon de un equipo
    @PatchMapping("/remove/{teamId}/team-mate")
    @ResponseStatus(HttpStatus.OK)
    public TeamDTO removeMate(@PathVariable Long teamId, @RequestBody Long pokemonId){
        return teamService.removeMate(teamId, pokemonId);
    }


}
