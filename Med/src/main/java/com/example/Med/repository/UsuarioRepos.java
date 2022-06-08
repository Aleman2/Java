
package com.example.Med.repository;

import com.example.Med.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepos extends JpaRepository<Usuario, Long> {

}