package co.edu.uptc.eisc.swii.biblioteca.domain;

public class Libro {
    private String nombre;
    private String descripcion;
    private String imagenUrl;

    public Libro(String nombre, String descripcion, String imagenUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }
    public Libro() {
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", descripcion=" + descripcion + ", imagenUrl=" + imagenUrl + "]";
    }
}
