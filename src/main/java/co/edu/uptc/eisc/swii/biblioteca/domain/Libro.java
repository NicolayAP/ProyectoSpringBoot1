package co.edu.uptc.eisc.swii.biblioteca.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    public Libro() {}

    public Libro(String nombre, String descripcion, String imagenUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getImagenUrl() { return imagenUrl; }
    public Editorial getEditorial() { return editorial; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
    public void setEditorial(Editorial editorial) { this.editorial = editorial; }

    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", descripcion=" + descripcion + ", imagenUrl=" + imagenUrl + "]";
    }
}
