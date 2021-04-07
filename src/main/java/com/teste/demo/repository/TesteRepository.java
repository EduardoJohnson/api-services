package com.teste.demo.repository;

import com.teste.demo.entity.TesteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepository extends JpaRepository<TesteEntity, Long> {
}
