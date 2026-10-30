package com.dawes.bibliotecajuegos.DAO.interfaz;

import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;

import java.util.ArrayList;

public interface IVideojuegoDAO {
    ArrayList<videojuegoDTO> buscarVideojuegos(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora);
}