package com.inventario.proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.inventario.Constantes;

@Service
public class ProveedorService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertarProveedor(Proveedor proveedor) {
        String sentenciaInsertarProveedor = String.format(Constantes.INSERTAR_PROVEEDOR, proveedor.marcaId(),
                proveedor.contactoId(), proveedor.nombre(), proveedor.descripcion(), proveedor.direccion());
        return jdbcTemplate.update(sentenciaInsertarProveedor);
    }

     public Proveedor getProveedor(Long id) {
        String sentenciaGetProveedor = String.format(Constantes.GET_PROVEEDOR, id);
        Proveedor proveedor = jdbcTemplate.queryForObject(sentenciaGetProveedor,
                new DataClassRowMapper<>(Proveedor.class));
        return proveedor;
    }

    public List<Proveedor> getAll() {
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(Constantes.GET_ALL_PROVEEDOR);
        List<Proveedor> listaProveedor = new ArrayList<>();
        queryResult.forEach(fila -> {
            Proveedor proveedor = new Proveedor((Long) fila.get("id"), (Long) fila.get("marcas_id"),
                    (Long) fila.get("contactos_id"), (String) fila.get("nombre"), (String) fila.get("direccion"), (String) fila.get("descripcion"));
            listaProveedor.add(proveedor);
        });
        return listaProveedor;
    }

}
