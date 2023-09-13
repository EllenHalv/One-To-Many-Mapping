package com.example.springboothibernatejavaguides.entity.repository;

import com.example.springboothibernatejavaguides.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}