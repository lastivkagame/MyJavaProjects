package com.example.springboot.controllers.api;

import com.example.springboot.entities.Animal;
import com.example.springboot.entities.AnimalImage;
import com.example.springboot.repositories.AnimalImageRepository;
import com.example.springboot.repositories.AnimalRepository;
import com.example.springboot.response.CommonResponse;
import com.example.springboot.services.AnimalService;
import com.example.springboot.wrappers.AnimalImageWrapper;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import com.example.juniorprogrammer.apicrud.response.CommonResponse;

@RestController
@RequestMapping("/api")
public class AnimalController {
    private final AnimalRepository animalRepository;
    private final AnimalImageRepository animalImageRepository;
    //private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalRepository animalRepository, AnimalImageRepository animalImageRepository) {
        this.animalRepository = animalRepository;
        this.animalImageRepository = animalImageRepository;
    }

    //https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
    //https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/

//    @GetMapping("/animals")
//    public List<Animal> index() { return (List<Animal>) animalRepository.findAll(); }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals(@RequestParam(required = false) String name) {
        try {
            List<Animal> animals = new ArrayList<Animal>();

            if (name == null)
                animalRepository.findAll().forEach(animals::add);
            else {
                animalRepository.findByName(name).forEach(animals::add);
            }

            if (animals.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(animals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/animals/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") int id) {
        Optional<Animal> animalsData = animalRepository.findById(id);

        if (animalsData.isPresent()) {
            return new ResponseEntity<>(animalsData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/animals")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        try {
            Animal _animal = animalRepository
                    .save(new Animal(animal.getName()));
            return new ResponseEntity<>(_animal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/animals/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable("id") int id, @RequestBody Animal animal) {
        Optional<Animal> animalData = animalRepository.findById(id);

        if (animalData.isPresent()) {
            Animal _animal = animalData.get();
            _animal.setName(animal.getName());
            //_animal.setImage(animal.getImage());
            return new ResponseEntity<>(animalRepository.save(_animal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/animals/{id}")
    public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable("id") int id) {
        try {
            animalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/animals")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            animalRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/animals/{name}")
    public ResponseEntity<List<Animal>> findByName(@PathVariable("id") String name) {
        try {
            List<Animal> animals = animalRepository.findByName(name);

            if (animals.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(animals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/upload-animal")
    public ResponseEntity<AnimalImageWrapper> upload(@RequestBody AnimalImageWrapper param){
        try{
            AnimalImage animalImage = new AnimalImage();
            animalImage.setAnimal(animalRepository.findById(param.getAnimalId()).get());
            animalImage.setContentType(param.getContentType());
            animalImage.setBase64(param.getBase64());
            animalImageRepository.save(animalImage);
            return new ResponseEntity<>(param, HttpStatus.OK);
        }
        catch (Exception e){
            return null;
        }
    }

    @GetMapping("/animals-images/{id}")
    public ResponseEntity<AnimalImage> getAnimalImageById(@PathVariable("id") int id) {
        Optional<AnimalImage> animalsData = animalImageRepository.findById(id);

        if (animalsData.isPresent()) {
            return new ResponseEntity<>(animalsData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/animals-images")
    public ResponseEntity<List<AnimalImage>> getAllAnimalsImages() {
        try {
            List<AnimalImage> animals = new ArrayList<AnimalImage>();

            animalImageRepository.findAll().forEach(animals::add);


            if (animals.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(animals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/animals/{id}")
//    Animal one(@PathVariable int id)  {
//
//        return animalRepository.findById(id)
//                .orElse(new Animal());
//    }
//
//    @PutMapping("/animals/{id}")
//    Animal replaceAnimal(@RequestBody Animal newAnimal, @PathVariable int id) {
//
//        return animalRepository.findById(id)
//                .map(user_animal -> {
//                    user_animal.setName(newAnimal.getName());
//                    user_animal.setImage(newAnimal.getImage());
//                    return animalRepository.save(user_animal);
//                })
//                .orElseGet(() -> {
//                    newAnimal.setId(id);
//                    return animalRepository.save(newAnimal);
//                });
//    }
//
//    @PostMapping("/animals/add")
//    public String addAnimal(@RequestBody Animal newAnimal) {
//        Animal an = new Animal(newAnimal.getName(), newAnimal.getName());
//        animalRepository.save(an);
//        return "animal add sucsessfully";
//    }
//
//
//    @DeleteMapping("/animals/{id}")
//    void deleteAnimal(@PathVariable int id) {
//        animalRepository.deleteById(id);
//    }

}
