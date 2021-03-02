package com.ironhack.pokemon.controller.dtos;

import com.ironhack.pokemon.model.*;

import javax.validation.constraints.*;

public class TrainerDTO {

    private Long id;
    @NotEmpty(message = "A trainer must have a name")
    private String name;
    @NotNull(message = "Look to your ID")
    private Integer age;
    @NotEmpty(message = "Are you really that boring?")
    private String hobby;
    @NotEmpty(message = "Go to facebook and pick your best face")
    private String photo;

    public TrainerDTO() {
    }

    public TrainerDTO(Trainer trainer) {
        this.id = trainer.getId();
        this.name = trainer.getName();
        this.age = trainer.getAge();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
