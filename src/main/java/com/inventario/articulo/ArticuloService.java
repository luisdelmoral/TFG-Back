package com.inventario.articulo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.inventario.Constantes;

@Service
public class ArticuloService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertarArticulo(Articulo articulo) {
        String sentenciaInsertarArticulo = String.format(Constantes.INSERTAR_ARTICULO, articulo.nombre(),
                articulo.marcaId(), articulo.nombre(), articulo.precio(), articulo.cantidad(), articulo.descatalogado(), articulo.descripcion());
        return jdbcTemplate.update(sentenciaInsertarArticulo);
    }

    public Articulo getArticulo(Long id) {
        String sentenciaGetArticulo = String.format(Constantes.GET_ARTICULO, id);
        Articulo articulo = jdbcTemplate.queryForObject(sentenciaGetArticulo,
                new DataClassRowMapper<>(Articulo.class));
        return articulo;
    }

    public List<Articulo> getAll() {
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(Constantes.GET_ALL_ARTICULO);
        List<Articulo> listaArticulo = new ArrayList<>();
        queryResult.forEach(fila -> {
            Articulo articulo = new Articulo((Long) fila.get("id"),(Long) fila.get ("marcas_id"),
                (String) fila.get ("nombre"), (String) fila.get("descripcion"), (BigDecimal) fila.get("precio"), (Integer) fila.get ("cantidad"), (Boolean) fila.get("descatalogado"));
                listaArticulo.add(articulo);
        });
        return listaArticulo;

    }
}
