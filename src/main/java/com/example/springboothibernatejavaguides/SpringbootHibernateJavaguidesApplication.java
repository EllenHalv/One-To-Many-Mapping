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

        Owner owner1 = new Owner("Bella", "Johnson", 19);

        Pet pet1 = new Pet("Karla", 2, "bunny");
        Pet pet2 = new Pet("Brad", 3, "lizard");

        owner1.getPets().add(pet1);
        owner1.getPets().add(pet2);

        this.ownerRepository.save(owner1);

        /*
        RADERA
        .delete(Entity klass)
        .deleteAll()
        .deleteById(Long)

        HITTA
        .exist(entity klass)
        .existById(Long)

        HÄMTA
        .findOne (Entity klass)
        .findAll()
        .findById(Long)
        */
    }
}
