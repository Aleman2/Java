
package com.example.Med.repository;

        import com.example.Med.entity.Diagnostico;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepos extends JpaRepository<Diagnostico, Long> {
}