package com.ironhack.pokemon.controller.interfaces;

import com.ironhack.pokemon.controller.dtos.*;
import org.springframework.web.bind.annotation.*;

public interface ITeamController {
    TeamDTO createNewTeam(TeamDTO teamDTO);
    TeamDTO addNewMate(Long teamId, Long pokemonId);
}
