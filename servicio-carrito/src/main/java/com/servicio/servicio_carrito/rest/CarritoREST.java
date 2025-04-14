package com.servicio.servicio_carrito.rest;

import com.netflix.discovery.converters.Auto;
import com.servicio.servicio_carrito.business.ICarritoBS;
import com.servicio.servicio_carrito.models.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarritoREST {
    @Autowired
    private ICarritoBS carritoBS;

    // http://localhost:8003/crear/Jose
    @PostMapping("/crear/{usuario}")
    public Carrito crear(@PathVariable String usuario) {
        return carritoBS.crear(usuario);
    }

    // http://localhost:8003/agregarPedido/2/cantidad/100/usuario/Jose
    @PutMapping("/agregarPedido/{id}/cantidad/{cantidad}/usuario/{usuario}")
    public Carrito agregarPedido(@PathVariable Long id, @PathVariable Integer cantidad, @PathVariable String usuario) {
        return carritoBS.agregarPedido(id, cantidad, usuario);
    }

    // http://localhost:8003/consultar/Jose
    @GetMapping("/consultar/{usuario}")
    public Carrito consultar(@PathVariable String usuario) {
        return carritoBS.consultar(usuario);
    }

    // http://localhost:8003/eliminarPedido/2/usuario/Jose
    @DeleteMapping("/eliminarPedido/{id}/usuario/{usuario}")
    public Carrito eliminarPedido(@PathVariable Long id, @PathVariable String usuario) {
        return carritoBS.eliminarPedido(id, usuario);
    }
}
