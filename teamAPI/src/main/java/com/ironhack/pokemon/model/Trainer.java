package com.ironhack.pokemon.model;

import com.ironhack.pokemon.controller.dtos.*;

import javax.persistence.*;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String hobby;
    private String photo;

//    Constructor
    public Trainer() {
    }

    public Trainer(String name, Integer age, String hobby, String photo) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.photo = photo;
    }

    public Trainer(TrainerDTO trainerDTO) {
        this.id = trainerDTO.getId();
        this.name = trainerDTO.getName();
        this.age = trainerDTO.getAge();
        this.hobby = trainerDTO.getHobby();
        this.photo = trainerDTO.getPhoto();
    }

    //    Getter and Setters
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
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
