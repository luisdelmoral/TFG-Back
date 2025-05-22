package com.inventario.proveedor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

     @PostMapping(value = "/anadir", headers = "Content-Type= multipart/form-data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RespuestaProveedor anadirProveedor(@RequestBody Proveedor proveedor) {
        try {
            int resultado = proveedorService.insertarProveedor(proveedor);
            return new RespuestaProveedor(resultado, new ArrayList<Proveedor>(), "");
        } catch (Exception exception) {
            return new RespuestaProveedor(0, new ArrayList<Proveedor>(), exception.getMessage());
        }

    }

    @GetMapping(value = "/get")
    public RespuestaProveedor getProveedor(@RequestParam Long id) {
        try {
            Proveedor proveedor = proveedorService.getProveedor(id);
            List<Proveedor> listaProveedores = new ArrayList<Proveedor>();
            listaProveedores.add(proveedor);
            RespuestaProveedor respuestaProveedor = new RespuestaProveedor(0, listaProveedores, "");
            return respuestaProveedor;
        } catch (Exception exception) {
            return new RespuestaProveedor(0, new ArrayList<Proveedor>(), exception.getMessage());
        }

    }

    @GetMapping("/getAll")
    public RespuestaProveedor getAll() {
        try {
            List<Proveedor> listaProveedores = proveedorService.getAll();
            return new RespuestaProveedor(0, listaProveedores, "");
        } catch (Exception exception) {
            return new RespuestaProveedor(0, new ArrayList<Proveedor>(), exception.getMessage());

        }
    }    






}   
