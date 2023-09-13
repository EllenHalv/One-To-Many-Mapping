package com.example.springboothibernatejavaguides;

import com.example.springboothibernatejavaguides.entity.Owner;
import com.example.springboothibernatejavaguides.entity.Pet;
import com.example.springboothibernatejavaguides.entity.repository.OwnerRepository;
import com.example.springboothibernatejavaguides.entity.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootHibernateJavaguidesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHibernateJavaguidesApplication.class, args);
    }

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {

        menu();

        //EN OWNER BASERAT PÅ ID
        Optional<Owner> fetchedOwner = ownerRepository.findById(1L);

        //SKRIV UT ALLA PETS SOM TILLHÖR EN OWNER (ID)
        /*List<Pet> fetchedPets = petRepository.findAll();
        List<Pet> ownerPets = new ArrayList<>();

        for (Pet pet : fetchedPets) {
            if(pet.getOwner().getId() == 1L) {
                ownerPets.add(pet);
                System.out.println(pet.getName());
            }
        }*/

        //SKRIV UT EN PET (ID)
        /*Optional<Pet> fetchedPet = petRepository.findById(1L);
        System.out.println(fetchedPet.get().getName());*/

        //SKRIV UT ALLA PETS
        /*List<Pet> fetchedPets = petRepository.findAll();
        for (Pet pet : fetchedPets) {
            System.out.println(pet.getName());
        }*/

/*      SKRIV UT NAMNET PÅ EN OWNER (MED ID)
        Optional<Owner> fetchedOwner = ownerRepository.findById(1L);

        System.out.println(fetchedOwner.get().getFirstName());
*/

/*      LÄGG TILL I DATABASEN
        Owner owner2 = new Owner("James", "Ubuntu", 58);

        ArrayList<Pet> pets = new ArrayList<>(); //här skapar vi en ArrayList "i förväg"
        pets.add(new Pet("Marv", 2, "dog"));
        pets.add(new Pet("Lory", 3, "cat"));

        owner2.setPets(pets);

        System.out.println("påbörjar koppling till databasen");

        ownerRepository.save(owner2);

        System.out.println("koppling till databasen klar");*/

/*
        Owner owner2 = new Owner("Bella", "Johnson", 19);

        Pet pet1 = new Pet("Karla", 2, "bunny");
        Pet pet2 = new Pet("Brad", 3, "lizard");

        owner1.getPets().add(pet1); //här hämtar vi ArrayListen och lägger till pet1
        owner1.getPets().add(pet2);

        this.ownerRepository.save(owner1);
*/

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

    private void menu() {
        System.out.println("Välkommen till djurkliniken!");
        System.out.println("Lägg till en person: ");
        Owner owner = addPerson();
        System.out.println("Lägg till ett djur: ");
        addPet(owner);
        System.out.println("Vill du lägga till ett djur till? y/n");
        if (yesOrNo()) {
            addPet(owner);
        }
        System.out.println("Vill du lägga till en person till? y/n");
        if (yesOrNo()) {
            addPerson();
        }
        System.out.println("Då är vi klara!");
        System.out.println("Det här är alla personer + deras djur: ");
        printAll();
    }

    private void printAll() {
        List<Owner> fetchedOwners = ownerRepository.findAll();
        for (Owner owner : fetchedOwners) {
            System.out.println(owner.getFirstName() + " " + owner.getLastName());
            for (Pet pet : owner.getPets()) {
                System.out.println("Husdjur: " + pet.getName());
            }
        }
    }

    private boolean yesOrNo() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    private void addPet(Owner owner) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Namn: ");
        String name = scanner.nextLine();
        System.out.println("Ålder: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Art: ");
        String species = scanner.nextLine();
        Pet pet = new Pet(owner, name, age, species);
        //owner.setPets(pets);

        //ownerRepository.save(owner);
        petRepository.save(pet);
    }

    private Owner addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Förnamn: ");
        String firstName = scanner.nextLine();
        System.out.println("Efternamn: ");
        String lastName = scanner.nextLine();
        System.out.println("Ålder: ");
        int age = scanner.nextInt();
        Owner owner = new Owner(firstName, lastName, age);
        ownerRepository.save(owner);
        return owner;
    }
}
