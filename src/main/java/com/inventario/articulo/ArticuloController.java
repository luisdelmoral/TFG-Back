package com.inventario.articulo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @PostMapping(value = "/anadir", headers = "Content-Type= multipart/form-data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RespuestaArticulo anadirArticulo(@RequestBody Articulo articulo) {
        try {
            int resultado = articuloService.insertarArticulo(articulo);
            return new RespuestaArticulo(resultado, new ArrayList<Articulo>(), "");
        } catch (Exception exception) {
            return new RespuestaArticulo(0, new ArrayList<Articulo>(), exception.getMessage());
        }

    }

    @GetMapping(value = "/get")
    public RespuestaArticulo getArticulo(@RequestParam Long id) {
        try {
            List<Articulo>listaArticulos = articuloService.getArticulo(id);
            RespuestaArticulo respuestaArticulo = new RespuestaArticulo(0, listaArticulos, "");
            return respuestaArticulo;
        } catch (Exception exception) {
            return new RespuestaArticulo(0, new ArrayList<Articulo>(), exception.getMessage());
        }

    }

     @GetMapping("/getAll")
    public RespuestaArticulo getAll() {
        try {
            List<Articulo> listaArticulos = articuloService.getAll();
            return new RespuestaArticulo(0, listaArticulos, "");
        } catch (Exception exception) {
            return new RespuestaArticulo(0, new ArrayList<Articulo>(), exception.getMessage());
        }
    }

    @CrossOrigin
    @DeleteMapping("/eliminar")
    public RespuestaArticulo delete (@RequestParam Long id) {
        try {
            int filasAfectadas = articuloService.eliminarArticulo(id);
            return new RespuestaArticulo(filasAfectadas, new ArrayList<Articulo>(), "");
        }
            catch (Exception exception) {
                return new RespuestaArticulo(0, new ArrayList<Articulo>(), exception.getMessage());
            }
        }
}



