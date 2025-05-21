package com.inventario.marca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.inventario.Constantes;

@Service
public class MarcaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertarMarca(Marca marca) {
        String sentenciaInsertarMarca = String.format(Constantes.INSERTAR_MARCA, marca.nombre(),
                marca.categoriaId(), marca.contactoId(), marca.descripcion());
        return jdbcTemplate.update(sentenciaInsertarMarca);
    }

    public Marca getMarca(Long id) {
        String sentenciaGetMarca = String.format(Constantes.GET_MARCA, id);
        Marca marca = jdbcTemplate.queryForObject(sentenciaGetMarca,
                new DataClassRowMapper<>(Marca.class));
        return marca;
    }

    public List<Marca> getAll() {
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(Constantes.GET_ALL_MARCA);
        List<Marca> listaMarca = new ArrayList<>();
        queryResult.forEach(fila -> {
            Marca marca = new Marca((Long) fila.get("id"),(Long) fila.get ("categorias_id"), 
                (Long) fila.get ("contactos_id"), (String) fila.get("nombre"), (String) fila.get ("descripcion"));
                listaMarca.add(marca);
        });
        return listaMarca;

    }

}
