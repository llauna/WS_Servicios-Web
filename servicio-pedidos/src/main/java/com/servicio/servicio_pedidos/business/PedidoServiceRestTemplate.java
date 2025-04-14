package com.servicio.servicio_pedidos.business;

import com.servicio.servicio_pedidos.models.Pedido;
import com.servicio.servicio_pedidos.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class PedidoServiceRestTemplate implements IPedidoService{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Pedido crearPedido(Long id, int cantidad) {
        // Buscar el producto con ese id
        Producto producto = restTemplate.getForObject("servicio-productos/buscar/{codigo}", Producto.class, id);

        // Crear el pedido y retornarlo
        return new Pedido(producto, cantidad);
    }
}
