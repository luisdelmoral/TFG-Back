//Expone un servicio Rest en el path /categoria y varios endpoints (...Mapping)
package com.inventario.categoria;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(value = "/anadir", headers = "Content-Type= multipart/form-data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RespuestaCategoria anadirCategoria(@RequestBody Categoria categoria) {
        try {
            int resultado = categoriaService.insertarCategoria(categoria);
            return new RespuestaCategoria(resultado, new ArrayList<Categoria>(), "");
        } catch (Exception exception) {
            return new RespuestaCategoria(0, new ArrayList<Categoria>(), exception.getMessage());
        }
    }

    @GetMapping(value = "/get")
    public RespuestaCategoria getCategoria(@RequestParam Long id) {
        try {
            Categoria categoria = categoriaService.getCategoria(id);
            List<Categoria> listaCategorias = new ArrayList<Categoria>();
            listaCategorias.add(categoria);
            RespuestaCategoria respuestaCategoria = new RespuestaCategoria(0, listaCategorias, "");
            return respuestaCategoria;
        } catch (Exception exception) {
            return new RespuestaCategoria(0, new ArrayList<Categoria>(), exception.getMessage());
        }
    }

    @GetMapping("/getAll")
    public RespuestaCategoria getAll() {
        try {
            List<Categoria> listaCategorias = categoriaService.getAll();
            return new RespuestaCategoria(0, listaCategorias, "");
        } catch (Exception exception) {
            return new RespuestaCategoria(0, new ArrayList<Categoria>(), exception.getMessage());

        }

    }
}