package com.ironhack.pokemon.controller.dtos;

public class TeamIdAndTrainerNameDTO {

    private Long teamId;
    private String trainerName;

    public TeamIdAndTrainerNameDTO() {
    }
    public TeamIdAndTrainerNameDTO(Long teamId, String trainerName) {
        setTeamId(teamId);
        setTrainerName(trainerName);
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
}
