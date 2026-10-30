package com.dawes.bibliotecajuegos.Service;

import com.dawes.bibliotecajuegos.DAO.interfaz.IVideojuegoDAO;
import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class videojuegoService {
    private final IVideojuegoDAO videojuegoDAO;

    public videojuegoService(IVideojuegoDAO videojuegoDAO) {
        this.videojuegoDAO = videojuegoDAO;
    }

    public ArrayList<videojuegoDTO> buscarVideojuegos(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora) {

        return videojuegoDAO.buscarVideojuegos(titulo, anio_lanzamiento, pegi, id_desarrolladora);

    }
}