package com.inventario.categoria;

import java.util.List;

public class RespuestaCategoria {

    private int filasAfectadas;
    private List<Categoria> listaCategorias;
    private String error;

    public RespuestaCategoria(int filasAfectadas, List<Categoria> listaCategorias, String error) {
        this.filasAfectadas = filasAfectadas;
        this.listaCategorias = listaCategorias;
        this.error = error;
    }

    public int getFilasAfectadas() {
        return filasAfectadas;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public String getError() {
        return error;
    }

    public void setFilasAfectadas(int filasAfectadas){
        this.filasAfectadas = filasAfectadas;
    }

    public void setListaCategorias(List<Categoria> listaCategorias){
        this.listaCategorias = listaCategorias;

    }

    public void setError(String error){
        this.error = error;
    }
    


}
