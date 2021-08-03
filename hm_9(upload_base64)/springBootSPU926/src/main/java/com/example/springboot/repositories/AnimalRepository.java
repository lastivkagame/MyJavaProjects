package com.example.springboot.repositories;

import com.example.springboot.entities.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    List<Animal> findByName(String name);
}
