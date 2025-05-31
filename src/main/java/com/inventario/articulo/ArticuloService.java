package com.inventario.articulo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        String df = articulo.precio().toString().replaceAll(",", ".");
        String sentenciaInsertarArticulo = String.format(Constantes.INSERTAR_ARTICULO, articulo.marcaId(),
                articulo.nombre(), df, articulo.cantidad(), articulo.descatalogado(), articulo.descripcion());
        return jdbcTemplate.update(sentenciaInsertarArticulo);
    }

    public List<Articulo> getArticulo(Long id) {
        String sentenciaGetArticulo = String.format(Constantes.GET_ARTICULO, id);
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sentenciaGetArticulo);
        List<Articulo> listaArticulo = new ArrayList<>();
        queryResult.forEach(fila -> {
            Articulo articulo = new Articulo((Long) fila.get("id"), (Long) fila.get("marcas_id"),
                    (String) fila.get("nombre"), (String) fila.get("descripcion"), (BigDecimal) fila.get("precio"),
                    (Integer) fila.get("cantidad"), (Boolean) fila.get("descatalogado"));
            listaArticulo.add(articulo);
        });
        return listaArticulo;
    }

    public List<Articulo> getAll() {
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(Constantes.GET_ALL_ARTICULO);
        List<Articulo> listaArticulo = new ArrayList<>();
        queryResult.forEach(fila -> {
            Articulo articulo = new Articulo((Long) fila.get("id"), (Long) fila.get("marcas_id"),
                    (String) fila.get("nombre"), (String) fila.get("descripcion"), (BigDecimal) fila.get("precio"),
                    (Integer) fila.get("cantidad"), (Boolean) fila.get("descatalogado"));
            listaArticulo.add(articulo);
        });
        return listaArticulo;

    }

    public int eliminarArticulo(Long id) {
        String sentenciaElminarArticulo = String.format(Constantes.ELIMINAR_ARTICULO, id);
        return jdbcTemplate.update(sentenciaElminarArticulo);
    }

    public int actulizarArticulo(Articulo articulo) {
        String sentenciaActuliarArticulo = String.format(Constantes.ACTUALIZAR_ARTICULO, articulo.nombre(), articulo.precio(), articulo.cantidad(), articulo.descatalogado(), articulo.id());
        return jdbcTemplate.update(sentenciaActuliarArticulo);
    }

}
