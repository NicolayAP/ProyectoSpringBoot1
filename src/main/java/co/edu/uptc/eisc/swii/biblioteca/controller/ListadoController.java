package co.edu.uptc.eisc.swii.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.uptc.eisc.swii.biblioteca.service.LibroService;
import co.edu.uptc.eisc.swii.biblioteca.service.EditorialService;
import co.edu.uptc.eisc.swii.biblioteca.domain.Libro;
import co.edu.uptc.eisc.swii.biblioteca.domain.Editorial;
import java.util.List;

@Controller
public class ListadoController {

    private final LibroService libroService;
    private final EditorialService editorialService;

    public ListadoController(LibroService libroService, EditorialService editorialService) {
        this.libroService = libroService;
        this.editorialService = editorialService;
    }

    @GetMapping({"/", "/listado"})
    public String listarLibros(Model model) {
        List<Libro> destacados = libroService.listarLibros();
        model.addAttribute("libros", destacados);
        return "listado";
    }

    @GetMapping("/libros/crear")
    public String mostrarFormularioCrearLibro(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("editoriales", editorialService.buscarTodos());
        return "formLibro"; 
    }

    @PostMapping("/libros/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        Editorial e = null;
        if (libro.getEditorial() != null && libro.getEditorial().getId() != null) {
            e = editorialService.buscarPorId(libro.getEditorial().getId());
        }
        libro.setEditorial(e);
        libroService.guardar(libro);
        return "redirect:/listado";
    }

    @GetMapping("/librosPorEditorial")
    public String listarLibrosPorEditorial(@RequestParam("idEditorial") int idEditorial, Model model) {
        List<Libro> libros = libroService.buscarPorEditorial(idEditorial);
        model.addAttribute("libros", libros);
        return "listado";
    }

    @GetMapping("/buscar")
    public String buscarLibros(@RequestParam(name = "consulta", required = false) String consulta, Model model) {
        List<Libro> libros = libroService.buscar(consulta);
        model.addAttribute("libros", libros);
        return "listado";
    }

    @GetMapping("/libros/detalle/{id}")
    public String detalleLibro(@PathVariable Integer id, Model model) {
        Libro libro = libroService.buscarPorId(id);
        model.addAttribute("libro", libro);
        return "detalle"; // opcional, si tienes vista detalle
    }
}
