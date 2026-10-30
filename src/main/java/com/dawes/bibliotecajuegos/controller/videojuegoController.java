package com.dawes.bibliotecajuegos.controller;

import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;
import com.dawes.bibliotecajuegos.Service.videojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class videojuegoController {
    private final videojuegoService videojuegoService;

    public videojuegoController(videojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    @GetMapping("/listadoVideojuegos")
    public String buscarVideojuegos(Model model) {
        ArrayList<videojuegoDTO> videojuegos = videojuegoService.buscarVideojuegos("", null, null, null);

        model.addAttribute("videojuegos", videojuegos);

        return "videojuego/listado";
    }

    @PostMapping("/listadoVideojuegos")
    public String biscarVideojuegos(@RequestParam String titulo,
                                    @RequestParam(required = false) Integer anio_lanzamiento,
                                    @RequestParam(required = false) Integer pegi,
                                    @RequestParam(required = false) Integer id_desarrolladora,
                                    Model model) {
        ArrayList<videojuegoDTO> videojuegos = videojuegoService.buscarVideojuegos(titulo, anio_lanzamiento, pegi, id_desarrolladora);

        ArrayList<videojuegoDTO> listaVideojuegos = videojuegoService.buscarVideojuegos(titulo, anio_lanzamiento, pegi, id_desarrolladora);

        model.addAttribute("videojuegos", videojuegos);

        return "videojuego/listado";
    }
}