package com.example.springboothibernatejavaguides;

import com.example.springboothibernatejavaguides.entity.Owner;
import com.example.springboothibernatejavaguides.entity.Pet;
import com.example.springboothibernatejavaguides.entity.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootHibernateJavaguidesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHibernateJavaguidesApplication.class, args);
    }

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner("Lucy");

        Pet pet1 = new Pet("Bobby", 2, "dog");
        Pet pet2 = new Pet("Tommy", 3, "cat");

        owner.getPets().add(pet1);
        owner.getPets().add(pet2);

        this.ownerRepository.save(owner);
    }
}
