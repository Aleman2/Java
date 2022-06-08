
package com.example.Med.repository;

import com.example.Med.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepos extends JpaRepository<Paciente, Long> {
}