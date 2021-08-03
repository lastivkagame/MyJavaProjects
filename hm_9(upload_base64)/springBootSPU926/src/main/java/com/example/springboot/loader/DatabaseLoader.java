package com.example.springboot.loader;

import com.example.springboot.entities.Animal;
import com.example.springboot.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final AnimalRepository animalRepository;

    @Autowired
    public DatabaseLoader(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.animalRepository.count()==0)
        {
            this.animalRepository.save(new Animal("Собака Джима"));
            this.animalRepository.save(new Animal("Кіт Аліси"));
            this.animalRepository.save(new Animal("Кродил Тома"));
        }
    }
}
