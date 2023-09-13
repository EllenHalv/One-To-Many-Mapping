package com.example.springboothibernatejavaguides.entity.repository;

import com.example.springboothibernatejavaguides.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}