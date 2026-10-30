package com.dawes.bibliotecajuegos.DAO.interfaz;

import com.dawes.bibliotecajuegos.DAO.impl.videojuegoDAO;
import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;

import java.util.ArrayList;

public interface InterfazVideojuegoDAO {
    ArrayList<videojuegoDTO> buscarVideojuego(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora);
}
