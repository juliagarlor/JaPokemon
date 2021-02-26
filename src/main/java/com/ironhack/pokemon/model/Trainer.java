package com.ironhack.pokemon.model;

import javax.persistence.*;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hobby;
    private String photo;

//    Constructor
    public Trainer() {
    }

    public Trainer(String name, String hobby, String photo) {
        this.name = name;
        this.hobby = hobby;
        this.photo = photo;
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
