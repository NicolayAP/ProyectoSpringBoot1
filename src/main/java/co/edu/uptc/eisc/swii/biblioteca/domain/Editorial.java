package co.edu.uptc.eisc.swii.biblioteca.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String sitioWeb;

    public Editorial() {}

    public Editorial(String nombre, String sitioWeb) {
        this.nombre = nombre;
        this.sitioWeb = sitioWeb;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getSitioWeb() { return sitioWeb; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSitioWeb(String sitioWeb) { this.sitioWeb = sitioWeb; }

    @Override
    public String toString() {
        return "Editorial [nombre=" + nombre + ", sitioWeb=" + sitioWeb + "]";
    }
}
