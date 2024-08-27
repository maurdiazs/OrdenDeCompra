package com.example.detalleordenescompra;

public class EstadoOrden {
    private int id;
    private String descripcion;

    // Constructor
    public EstadoOrden(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
