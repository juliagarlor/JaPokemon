package com.ironhack.pokemon.service.interfaces;

import com.ironhack.pokemon.controller.dtos.*;

public interface ITeamService {
    TeamDTO createNewTeam(TeamDTO teamDTO);
    TeamDTO addNewMate(Long teamId, Long pokemonId);
    TeamDTO removeMate(Long teamId, Long pokemonId);
}
