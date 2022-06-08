package com.example.Med.repository;

import com.example.Med.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepos extends JpaRepository<Cita, Long> {
}