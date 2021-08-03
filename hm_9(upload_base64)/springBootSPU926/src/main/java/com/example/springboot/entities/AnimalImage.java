package com.example.springboot.entities;

import javax.persistence.*;

@Entity
public class AnimalImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Animal animal;

    @Lob
    private String base64;

    public AnimalImage() {
    }

    public AnimalImage(Animal animal, String base64) {
        this.animal = animal;
        this.base64 = base64;
    }

    public AnimalImage(Animal animal, String base64, String contentType) {
        this.animal = animal;
        this.base64 = base64;
        this.contentType = contentType;
    }

    public AnimalImage(String base64) {
        this.base64 = base64;
    }

    private String contentType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
