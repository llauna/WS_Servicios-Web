package com.servicio.servicio_carrito.clients;

import com.servicio.servicio_carrito.models.Pedido;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient (name="servicio_pedidos")
public interface PedidosClienteFeign {
    @GetMapping("/buscar/{id}/cantidad/{cantidad}")
    public Pedido crearPedido(@PathVariable Long id, @PathVariable int cantidad);
}
