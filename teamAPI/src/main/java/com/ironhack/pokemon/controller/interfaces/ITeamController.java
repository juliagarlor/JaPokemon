package com.ironhack.pokemon.controller.interfaces;

import com.ironhack.pokemon.controller.dtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface ITeamController {
    List<TeamDTO> getAllTeams();
    TeamDTO addNewMate(Long teamId, Long pokemonId);
    TeamDTO removeMate(Long teamId, Long pokemonId);
}
