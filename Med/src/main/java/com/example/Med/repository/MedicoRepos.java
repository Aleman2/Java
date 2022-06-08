
package com.example.Med.repository;

import com.example.Med.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepos extends JpaRepository<Medico, Long> {
}