package co.edu.uptc.eisc.swii.biblioteca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uptc.eisc.swii.biblioteca.domain.Libro;
import co.edu.uptc.eisc.swii.biblioteca.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> buscarDestacados() {
        return libroRepository.findAllByOrderByNombre();
    }

    public List<Libro> buscarPorEditorial(int idEditorial) {
        return libroRepository.findByEditorialIdOrderByNombre(idEditorial);
    }

    public List<Libro> buscar(String consulta) {
        if (consulta == null || consulta.isBlank()) {
            return libroRepository.findAllByOrderByNombre();
        }
        return libroRepository.findByNombreContainingIgnoreCaseOrderByNombre(consulta);
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro buscarPorId(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}
