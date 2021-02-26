package com.ironhack.pokemon.service.impl;

import com.ironhack.pokemon.controller.dtos.*;
import com.ironhack.pokemon.model.*;
import com.ironhack.pokemon.repository.*;
import com.ironhack.pokemon.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamDTO createNewTeam(TeamDTO teamDTO) {
        Team team = new Team(teamDTO);
        teamRepository.save(team);
        return new TeamDTO(team);
    }

    public TeamDTO addNewMate(Long teamId, Long pokemonId) {
        return null;
    }
}
