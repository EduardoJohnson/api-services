package com.teste.demo.repository;


import com.teste.demo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}