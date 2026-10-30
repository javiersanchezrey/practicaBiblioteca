package com.dawes.bibliotecajuegos.DAO.impl;
import com.dawes.bibliotecajuegos.DAO.interfaz.IVideojuegoDAO;
import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;
import com.dawes.bibliotecajuegos.Repository.videojuegoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class videojuegoDAO implements IVideojuegoDAO {

    private final videojuegoRepository videojuegoRepository;

    public videojuegoDAO(videojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    @Override
    public ArrayList<videojuegoDTO> listarVideojuegos(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora) {
        return videojuegoRepository.buscarVideojuego(titulo, anio_lanzamiento, pegi, id_desarrolladora);
    }
}