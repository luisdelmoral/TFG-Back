package com.inventario.contactos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.inventario.Constantes;

@Service
public class ContactoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertarContacto(Contacto contacto) {
        String sentenciaInsertarContacto = String.format(Constantes.INSERTAR_CONTACTO, contacto.nombre(),
                contacto.apellidos(), contacto.email(), contacto.telefono());
        return jdbcTemplate.update(sentenciaInsertarContacto);
    }

    public Contacto getContacto(Long id) {
        String sentenciaGetContacto = String.format(Constantes.GET_CONTACTO, id);
        Contacto contacto = jdbcTemplate.queryForObject(sentenciaGetContacto,
                new DataClassRowMapper<>(Contacto.class));
        return contacto;
    }

    public List<Contacto> getAll() {
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(Constantes.GET_ALL_CONTACTO);
        List<Contacto> listaContacto = new ArrayList<>();
        queryResult.forEach(fila -> {
            Contacto contacto = new Contacto((Long) fila.get("id"), (String) fila.get("nombre"),
                    (String) fila.get("apellidos"), (String) fila.get("email"), (Integer) fila.get("telefono"));
            listaContacto.add(contacto);
        });
        return listaContacto;
    }

}
