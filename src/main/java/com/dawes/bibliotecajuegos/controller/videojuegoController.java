package com.dawes.bibliotecajuegos.controller;

import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;
import com.dawes.bibliotecajuegos.Service.videojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/videojuegos")
public class videojuegoController {
    private  final videojuegoService videojuegoService;

    public videojuegoController(videojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    @GetMapping("/listadovideojuegos")
    public String listadoVideojuegos(Model model){
        //preguntar si eso esta bien asi.
        ArrayList<videojuegoDTO> listaVideojuegos = videojuegoService.buscarVideojuego("", null, 1, 1);

        model.addAttribute("listaVideojuegos", listaVideojuegos);
        return "videojuegos/listadovideojuegos";
    }

    @PostMapping("/listadovideojuegos")
    public String buscarVideojuegos(
                                    @RequestParam String titulo,
                                    @RequestParam Integer anio_lanzamiento,
                                    @RequestParam Integer pegi,
                                    @RequestParam Integer id_desarrolladora,
                                    Model model
                                ){
        //en el pdf de alumnos hay mas cosas preguntar si las tengo que poner.

        ArrayList<videojuegoDTO> listaVideojuegos = videojuegoService.buscarVideojuego(titulo, anio_lanzamiento, pegi, id_desarrolladora);

        model.addAttribute("listaVideojuegos", listaVideojuegos);
        return "videojuegos/listadovideojuegos";
    }
}
