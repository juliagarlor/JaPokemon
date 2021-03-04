package com.ironhack.pokemon.service.interfaces;

import com.ironhack.pokemon.controller.dtos.*;

import java.util.*;

public interface ITeamService {
    List<TeamDTO> getAllTeams();
    List<TeamDTO> checkTeamByName(String name);
    TeamDTO addNewMate(Long teamId, Long pokemonId);
    TeamDTO removeMate(Long teamId, Long pokemonId);
    List<TeamIdAndTrainerNameDTO> getTeamIdAndTrainerName();
    TeamDTO getTeamById(Long id);
}
