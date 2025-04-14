package com.servicio.servicio_carrito.models;

import java.io.Serializable;

public class Producto implements Serializable {

    private Long ID;
    private String descripcion;
    private double precio;
    private Integer port;

    public Producto() {}

    public Producto(String descripcion, double precio) {
        super();
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "ID=" + ID +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", port=" + port +
                '}';
    }
}
