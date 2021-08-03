package com.example.springboot.services;

import com.example.springboot.entities.Animal;
import com.example.springboot.entities.AnimalImage;
import com.example.springboot.repositories.AnimalImageRepository;
import com.example.springboot.repositories.AnimalRepository;
import com.example.springboot.wrappers.AnimalImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AnimalImageRepository animalImageRepository;

    @Override
    public Animal addAnimal(Animal param) {

        return animalRepository.save(param);
    }

    @Override
    public List<Animal> getallAnimal() {
        return (List<Animal>) animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(int id) {
        return animalRepository.findById(id).get();
    }

    @Override
    public Animal updateAnimal(Animal param) {

        Animal findAnimal = animalRepository.findById(param.getId()).get();
        findAnimal.setName(param.getName());

        return animalRepository.save(findAnimal);
    }

    @Override
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);

    }

    @Override
    public AnimalImage upload(AnimalImageWrapper animalImageWrapper) {

        AnimalImage animalImage = new AnimalImage();
        animalImage.setAnimal(animalRepository.findById(animalImageWrapper.getAnimalId()).get());
        animalImage.setContentType(animalImageWrapper.getContentType());
        animalImage.setBase64(animalImageWrapper.getBase64());

        return animalImageRepository.save(animalImage);
    }
}