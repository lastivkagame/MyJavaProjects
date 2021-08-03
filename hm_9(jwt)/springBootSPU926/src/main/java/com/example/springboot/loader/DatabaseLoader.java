package com.example.springboot.loader;

import com.example.springboot.constants.Roles;
import com.example.springboot.entities.Animal;
import com.example.springboot.entities.Role;
import com.example.springboot.entities.User;
import com.example.springboot.repositories.AnimalRepository;
import com.example.springboot.repositories.RoleRepository;
import com.example.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final AnimalRepository animalRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseLoader(AnimalRepository animalRepository, RoleRepository roleRepository,
                          UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.animalRepository = animalRepository;
        this.roleRepository=roleRepository;
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.animalRepository.count()==0)
        {
            this.animalRepository.save(new Animal("Собака Джима"));
            this.animalRepository.save(new Animal("Кіт Аліси"));
            this.animalRepository.save(new Animal("Кродил Тома"));
        }
        if(this.roleRepository.count()==0)
        {
            this.roleRepository.save(new Role(Roles.Admin));
            this.roleRepository.save(new Role(Roles.User));
        }

        if(this.userRepository.count()==0)
        {
            this.userRepository.save(
              new User("semen@gmail.com",passwordEncoder.encode("123456"))
            );
        }
    }
}
