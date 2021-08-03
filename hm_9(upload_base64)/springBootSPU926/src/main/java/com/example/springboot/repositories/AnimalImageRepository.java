package com.example.springboot.repositories;

import com.example.springboot.entities.Animal;
import com.example.springboot.entities.AnimalImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalImageRepository extends JpaRepository<AnimalImage, Integer> {

}
