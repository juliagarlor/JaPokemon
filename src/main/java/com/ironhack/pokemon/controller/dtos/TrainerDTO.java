package com.ironhack.pokemon.controller.dtos;

import com.ironhack.pokemon.model.*;

public class TrainerDTO {

    private Long id;
    private String name;
    private String hobby;
    private String photo;

    public TrainerDTO(Trainer trainer) {
        this.id = trainer.getId();
        this.name = trainer.getName();
        this.hobby = trainer.getHobby();
        this.photo = trainer.getPhoto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
