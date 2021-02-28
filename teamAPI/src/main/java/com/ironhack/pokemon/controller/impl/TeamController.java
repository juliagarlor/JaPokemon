package com.ironhack.pokemon.controller.impl;

import com.ironhack.pokemon.controller.dtos.*;
import com.ironhack.pokemon.controller.interfaces.*;
import com.ironhack.pokemon.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
public class TeamController implements ITeamController {

    @Autowired
    private ITeamService teamService;

//    get all teams with the whole information about its trainers and pokemons
    @GetMapping("/teams")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDTO> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/team/trainer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDTO> getTeamsByName(@PathVariable String name){
        return teamService.checkTeamByName(name);
    }

//    add a new pokemon to the team
    @PatchMapping("/add/{teamId}/team-mate")
    @ResponseStatus(HttpStatus.OK)
    public TeamDTO addNewMate(@PathVariable Long teamId, @RequestBody Long pokemonId){
        return teamService.addNewMate(teamId, pokemonId);
    }

//    remove a team mate from the team
    @PatchMapping("/remove/{teamId}/team-mate")
    @ResponseStatus(HttpStatus.OK)
    public TeamDTO removeMate(@PathVariable Long teamId, @RequestBody Long pokemonId){
        return teamService.removeMate(teamId, pokemonId);
    }
}
