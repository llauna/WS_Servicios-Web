package com.servicio.servicio_productos.models;

import jakarta.persistence.*;

import java.io.Serializable;



@Entity
@Table(name = "PRODUCTOS")
public class Producto  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // incremental
    @Column(name = "ID")
    private Long ID;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private double precio;

    // No quiero que se guarde en la BBDD
    @Transient
    private Integer port;

    public Producto() {
        // TODO Auto-generated constructor stub
    }

    public Producto(String descripcion, double precio) {
        super();
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
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
}
