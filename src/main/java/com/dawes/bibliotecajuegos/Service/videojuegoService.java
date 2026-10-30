package com.dawes.bibliotecajuegos.Service;

import com.dawes.bibliotecajuegos.DAO.impl.videojuegoDAO;
import com.dawes.bibliotecajuegos.DAO.interfaz.InterfazVideojuegoDAO;
import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;

import java.util.ArrayList;

public class videojuegoService {
    private final InterfazVideojuegoDAO iVideojuegoDAO;

    public videojuegoService(InterfazVideojuegoDAO iVideojuegoDAO) {
        this.iVideojuegoDAO = iVideojuegoDAO;
    }

    public ArrayList<videojuegoDTO> buscarVideojuego(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora){

        //arreglar el fallo. (preguntar a Adri si no lo resuelvo)
        return videojuegoDAO.buscarVideojuego(titulo, anio_lanzamiento, pegi, id_desarrolladora);
    }

    //Aqui va todas las comprobaciones que se tienen que hacer en la pagina 4 del pdf.

}
