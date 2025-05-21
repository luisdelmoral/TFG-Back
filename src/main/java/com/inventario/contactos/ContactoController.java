package com.inventario.contactos;

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
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @PostMapping(value = "/anadir", headers = "Content-Type= multipart/form-data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RespuestaContacto anadirContacto(@RequestBody Contacto contacto) {
        try {
            int resultado = contactoService.insertarContacto(contacto);
            return new RespuestaContacto(resultado, new ArrayList<Contacto>(), "");
        } catch (Exception exception) {
            return new RespuestaContacto(0, new ArrayList<Contacto>(), exception.getMessage());
        }

    }

    @GetMapping(value = "/get")
    public RespuestaContacto getContacto(@RequestParam Long id) {
        try {
            Contacto contacto = contactoService.getContacto(id);
            List<Contacto> listaContactos = new ArrayList<Contacto>();
            listaContactos.add(contacto);
            RespuestaContacto respuestaContacto = new RespuestaContacto(0, listaContactos, "");
            return respuestaContacto;
        } catch (Exception exception) {
            return new RespuestaContacto(0, new ArrayList<Contacto>(), exception.getMessage());
        }

    }

    @GetMapping("/getAll")
    public RespuestaContacto getAll() {
        try {
            List<Contacto> listaContactos = contactoService.getAll();
            return new RespuestaContacto(0, listaContactos, "");
        } catch (Exception exception) {
            return new RespuestaContacto(0, new ArrayList<Contacto>(), exception.getMessage());

        }
    }    

}
    
    
    


