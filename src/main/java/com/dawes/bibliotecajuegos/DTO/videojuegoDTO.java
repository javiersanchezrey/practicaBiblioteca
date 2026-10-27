package com.dawes.bibliotecajuegos.DTO;

public class videojuegoDTO {
    private String titulo;
    private Integer anio_lanzamiento;
    private Integer pegi;
    private Integer id_desarrolladora;

    public  videojuegoDTO() {}

    public videojuegoDTO(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora) {
        this.titulo = titulo;
        this.anio_lanzamiento = anio_lanzamiento;
        this.pegi = pegi;
        this.id_desarrolladora = id_desarrolladora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio_lanzamiento() {
        return anio_lanzamiento;
    }

    public void setAnio_lanzamiento(Integer anio_lanzamiento) {
        this.anio_lanzamiento = anio_lanzamiento;
    }

    public Integer getPegi() {
        return pegi;
    }

    public void setPegi(Integer pegi) {
        this.pegi = pegi;
    }

    public Integer getId_desarrolladora() {
        return id_desarrolladora;
    }

    public void setId_desarrolladora(Integer id_desarrolladora) {
        this.id_desarrolladora = id_desarrolladora;
    }
}
