package com.servicio.servicio_pedidos.rest;

import com.servicio.servicio_pedidos.business.IPedidoService;
import com.servicio.servicio_pedidos.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PedidoREST {
    @Autowired
    private IPedidoService service;

    // http://localhost:8002/buscar/3/cantidad/50
    @GetMapping("/buscar/{id}/cantidad/{cantidad}")
    public Pedido crearPedido(@PathVariable Long id, @PathVariable int cantidad) {
        return service.crearPedido(id, cantidad);
    }
}
