package com.example.springboot.services;

import com.example.springboot.entities.Animal;
import com.example.springboot.entities.AnimalImage;
import com.example.springboot.wrappers.AnimalImageWrapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface AnimalService {
    Animal addAnimal(Animal param);

    List<Animal> getallAnimal();

    Animal getAnimalById(int id);

    Animal updateAnimal(Animal param);

    void deleteAnimal(int id);

    AnimalImage upload(AnimalImageWrapper animalImageWrapper);
}


