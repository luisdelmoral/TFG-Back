package com.inventario.marca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping(value = "/anadir", headers = "Content-Type= multipart/form-data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RespuestaMarca anadirMarca(@RequestBody Marca marca) {
        try {
            int resultado = marcaService.insertarMarca(marca);
            return new RespuestaMarca(resultado, new ArrayList<Marca>(), "");
        } catch (Exception exception) {
            return new RespuestaMarca(0, new ArrayList<Marca>(), exception.getMessage());
        }

    }

    @GetMapping(value = "/get")
    public RespuestaMarca getMarca(@RequestParam Long id) {
        try {
            Marca marca = marcaService.getMarca(id);
            List<Marca> listaMarcas = new ArrayList<Marca>();
            listaMarcas.add(marca);
            RespuestaMarca respuestaMarca = new RespuestaMarca(0, listaMarcas, "");
            return respuestaMarca;
        } catch (Exception exception) {
            return new RespuestaMarca(0, new ArrayList<Marca>(), exception.getMessage());
        }

    }

    @GetMapping("/getAll")
    public RespuestaMarca getAll() {
        try {
            List<Marca> listaMarcas = marcaService.getAll();
            return new RespuestaMarca(0, listaMarcas, "");
        } catch (Exception exception) {
            return new RespuestaMarca(0, new ArrayList<Marca>(), exception.getMessage());
        }
    }

}
