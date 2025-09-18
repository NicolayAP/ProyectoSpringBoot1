package co.edu.uptc.eisc.swii.biblioteca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uptc.eisc.swii.biblioteca.domain.Editorial;
import co.edu.uptc.eisc.swii.biblioteca.repository.EditorialRepository;

@Service
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public List<Editorial> buscarTodos(){
        return editorialRepository.findAll();
    }

    public Editorial buscarPorId(Integer id) {
        return editorialRepository.findById(id).orElse(null);
    }
}
