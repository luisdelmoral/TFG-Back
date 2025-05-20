package com.inventario.categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.inventario.Constantes;

@Service
public class CategoriaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertarCategoria(Categoria categoria) {
        String sentenciaInsertarCategoria = String.format(Constantes.INSERTAR_CATEGORIA, categoria.nombreCategoria());
        return jdbcTemplate.update(sentenciaInsertarCategoria);
    }

    public Categoria getCategoria(Long id) {
        String sentenciaGetCategoria = String.format(Constantes.GET_CATEGORIA, id);
        Categoria categoria = jdbcTemplate.queryForObject(sentenciaGetCategoria,
                new DataClassRowMapper<>(Categoria.class));
        return categoria;

    }

    public List<Categoria> getAll() {
        List<Map<String,Object>> queryResult = jdbcTemplate.queryForList(Constantes.GET_ALL_CATEGORIA);
        List<Categoria> listaCategoria = new ArrayList<>();
        queryResult.forEach(fila ->{
            Categoria categoria = new Categoria((Long)fila.get("id"), (String)fila.get("nombre_categoria"));
            listaCategoria.add(categoria); 
        });
        return listaCategoria; 
    }

}
