package co.edu.uptc.eisc.swii.biblioteca.service;
import java.util.List;
import co.edu.uptc.eisc.swii.biblioteca.domain.Libro;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    public List<Libro> buscarDestacados(){
        List<Libro> destacados = new java.util.ArrayList<>();
        Libro libro = new Libro();
        libro.setNombre("Metamodelos");
        libro.setDescripcion("Descripcion..");
        libro.setImagenUrl("https://elcomercio.pe/mag/fama/goku-10-cosas-que-no-sabias-sobre-el-personaje-de-dragon-ball-series-animes-nnda-nnlt-noticia/");
        destacados.add(libro);

        Libro libro2 = new Libro();
        libro2.setNombre("Java");
        libro2.setDescripcion("Descripcion..");
        libro2.setImagenUrl("https://store.steampowered.com/app/1030300/Hollow_Knight_Silksong/?l=spanish&curator_clanid=43198361");
        destacados.add(libro2);

         Libro libro3 = new Libro();
        libro3.setNombre("Spring");
        libro3.setDescripcion("Descripcion..");
        libro3.setImagenUrl("https://www.3djuegos.com/juegos/hollow-knight-silksong/noticias/criticado-silksong-no-culpa-team-cherry-quieres-enfadarte-alguien-que-sea-nepal");

        return destacados;
    }

}
