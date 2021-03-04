package com.ironhack.pokemon.controller.impl;

import com.fasterxml.jackson.databind.*;
import com.ironhack.pokemon.model.*;
import com.ironhack.pokemon.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
class TeamControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private PokemonRepository pokemonRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Trainer trainer1 = new Trainer("Misty", 11, "Pokemon de agua", "misty.png");
        Trainer trainer2 = new Trainer("Maya", 10, "Concursos pokemon", "maya.png");
        trainerRepository.saveAll(List.of(trainer1, trainer2));

        Pokemon goldeen = new Pokemon(118L);
        List<Pokemon> mistyTeam = new ArrayList<>();
        mistyTeam.add(goldeen);
        Pokemon piplup = new Pokemon(393L);
        List<Pokemon> mayaTeam = new ArrayList<>();
        mayaTeam.add(piplup);
        pokemonRepository.saveAll(List.of(goldeen, piplup));

        Team team1 = new Team(trainer1, mistyTeam);
        Team team2 = new Team(trainer2, mayaTeam);
        teamRepository.saveAll(List.of(team1, team2));
    }

    @AfterEach
    void tearDown() {
        teamRepository.deleteAll();
        trainerRepository.deleteAll();
        pokemonRepository.deleteAll();
    }

    @Test
    void getAllTeams_void_ListOfTeamDTO() throws Exception {
        MvcResult result = mockMvc.perform(get("/teams")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Misty"));
        assertTrue(result.getResponse().getContentAsString().contains("Maya"));
    }

    @Test
    void addNewMate_PokedexId_TeamDTO() throws Exception {
//        Lets add starmie to misty team
        Long mistyTeamId = teamRepository.findAll().get(0).getTeamId();

        Long starmiePokedex = 121L;
        String body = objectMapper.writeValueAsString(starmiePokedex);

        MvcResult result = mockMvc.perform(put("/add/"+ mistyTeamId + "/team-mate").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        assertTrue(result.getResponse().getContentAsString().contains("121"));
        assertTrue(result.getResponse().getContentAsString().contains("Misty"));
        assertFalse(result.getResponse().getContentAsString().contains("Maya"));
        assertEquals(2, teamRepository.findAll().get(0).getPokemonList().size());
    }

    @Test
    void removeMate_PokemonId_TeamDTO() throws Exception {
//        Lets remove goldeen from misty team
        Long mistyTeamId = teamRepository.findAll().get(0).getTeamId();
        Long goldeenId = pokemonRepository.findAll().get(0).getId();

        String body = objectMapper.writeValueAsString(goldeenId);

        MvcResult result = mockMvc.perform(put("/remove/"+ mistyTeamId + "/team-mate").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Misty"));
        assertFalse(result.getResponse().getContentAsString().contains("Maya"));
        assertEquals(0, teamRepository.findAll().get(0).getPokemonList().size());
    }
}