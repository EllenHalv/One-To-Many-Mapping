package com.example.springboothibernatejavaguides.entity.repository;

import com.example.springboothibernatejavaguides.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}