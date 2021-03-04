package com.ironhack.pokemon.controller.impl;

import com.fasterxml.jackson.databind.*;
import com.ironhack.pokemon.controller.dtos.*;
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
class TrainerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private TeamRepository teamRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Trainer trainer1 = new Trainer("Misty", 11, "Pokemon de agua", "misty.png");
        Trainer trainer2 = new Trainer("Maya", 10, "Concursos pokemon", "maya.png");
        trainerRepository.saveAll(List.of(trainer1, trainer2));

        List<Pokemon> mistyTeam = new ArrayList<>();
        List<Pokemon> mayaTeam = new ArrayList<>();

        Team team1 = new Team(trainer1, mistyTeam);
        Team team2 = new Team(trainer2, mayaTeam);
        teamRepository.saveAll(List.of(team1, team2));
    }

    @AfterEach
    void tearDown() {
        teamRepository.deleteAll();
        trainerRepository.deleteAll();
    }

    @Test
    void createNewTrainer_validTrainer_TrainerDTO() throws Exception {
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setName("Aura");
        trainerDTO.setAge(10);
        trainerDTO.setHobby("Concursos pokemon");
        trainerDTO.setPhoto("aura.png");
        String body = objectMapper.writeValueAsString(trainerDTO);

        MvcResult result = mockMvc.perform(post("/trainer").content(body).contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Aura"));
        assertFalse(result.getResponse().getContentAsString().contains("Misty"));
        assertEquals(3, trainerRepository.findAll().size());
    }

    @Test
    void getAllTrainers_void_ListOfTrainerDTO() throws Exception {
        MvcResult result = mockMvc.perform(get("/trainers")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Maya"));
        assertTrue(result.getResponse().getContentAsString().contains("Misty"));
    }

    @Test
    void getTrainerById_validId_TrainerDTO() throws Exception {
        Long mistyId = trainerRepository.findAll().get(0).getId();

        MvcResult result = mockMvc.perform(get("/trainer/" + mistyId)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Misty"));
        assertFalse(result.getResponse().getContentAsString().contains("Maya"));
    }

    @Test
    void removeTrainer_validId_void() throws Exception {
        Long mistyId = trainerRepository.findAll().get(0).getId();
        mockMvc.perform(delete("/trainer/" + mistyId));
        assertEquals(1, trainerRepository.findAll().size());
        assertEquals(1, teamRepository.findAll().size());
    }
}