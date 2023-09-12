package com.example.springboothibernatejavaguides.entity.repository;

import com.example.springboothibernatejavaguides.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}