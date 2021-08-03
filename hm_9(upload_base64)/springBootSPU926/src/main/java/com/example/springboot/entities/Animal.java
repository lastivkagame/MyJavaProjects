package com.example.springboot.entities;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

   /* @Column(length = 255, nullable = true)
    private String image;*/

    public Animal() {
    }



    public Animal(String name, String image) {
        this.name = name;
        //this.image = image;
    }



    public Animal(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
