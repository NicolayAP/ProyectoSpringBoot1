package co.edu.uptc.eisc.swii.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import co.edu.uptc.eisc.swii.biblioteca.service.LibroService;
import co.edu.uptc.eisc.swii.biblioteca.domain.Libro;
import java.util.List;


@Controller
public class ListadoController {

    private final LibroService libroService;

    public ListadoController(LibroService libroService) {
        this.libroService = libroService;
    }

    @RequestMapping("/listado")
    public String listarLibros(Model model) {
        List<Libro> destacados = libroService.buscarDestacados();
        model.addAttribute("libros", destacados);
        return "listado";
    }
}
