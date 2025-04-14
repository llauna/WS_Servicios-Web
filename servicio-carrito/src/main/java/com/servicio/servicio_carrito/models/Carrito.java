package com.servicio.servicio_carrito.models;



import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.ArrayList;

public class Carrito {
    @Id
    private String id;

    private String usuario;
    private List<Pedido> contenido = new ArrayList<Pedido>();
    private double importe;

    public Carrito() {}

    public Carrito(String usuario, List<Pedido> contenido, double importe) {
        super();
        this.usuario = usuario;
        this.contenido = contenido;
        this.importe = importe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Pedido> getContenido() {
        return contenido;
    }

    public void setContenido(List<Pedido> contenido) {
        this.contenido = contenido;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id='" + id + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contenido=" + contenido +
                ", importe=" + importe +
                '}';
    }
}

