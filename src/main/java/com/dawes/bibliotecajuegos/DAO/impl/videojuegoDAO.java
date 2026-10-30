package com.dawes.bibliotecajuegos.DAO.impl;

import com.dawes.bibliotecajuegos.DAO.interfaz.InterfazVideojuegoDAO;
import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;
import com.dawes.bibliotecajuegos.Repository.videojuegoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class videojuegoDAO implements InterfazVideojuegoDAO {
    private final videojuegoRepository juegoRepository;

    public videojuegoDAO(videojuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
    public ArrayList<videojuegoDTO> buscarVideojuego(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora) {
        return juegoRepository.listarVideojuego(titulo, anio_lanzamiento, pegi, id_desarrolladora);
    }
}
