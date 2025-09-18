package co.edu.uptc.eisc.swii.biblioteca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.uptc.eisc.swii.biblioteca.domain.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    // Usamos un @Query explícito
    @Query("from Libro v order by v.nombre")
    List<Libro> buscarTodos();

    @Query("from Libro v where v.editorial.id = ?1 order by v.nombre")
    List<Libro> buscarPorEditorial(int idEditorial);

    // Tu consulta tenía errores de sintaxis ("from libro 1")
    // Mejor usar JPQL correcto o métodos derivados
    @Query("from Libro v where lower(v.nombre) like lower(concat('%', ?1, '%')) order by v.nombre")
    List<Libro> buscar(String nombre);

    // Si prefieres usar métodos derivados de Spring Data JPA en vez de @Query:
    List<Libro> findAllByOrderByNombre();
    List<Libro> findByEditorialIdOrderByNombre(int idEditorial);
    List<Libro> findByNombreContainingIgnoreCaseOrderByNombre(String nombre);
}
