package co.edu.uptc.eisc.swii.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.uptc.eisc.swii.biblioteca.domain.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
}
