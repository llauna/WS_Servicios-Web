package com.servicio.servicio_pedidos.business;

import com.servicio.servicio_pedidos.clients.ProductosClientFeign;
import com.servicio.servicio_pedidos.models.Pedido;
import com.servicio.servicio_pedidos.models.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
;


@Primary
public class PedidoServiceFeign implements IPedidoService{

    @Autowired
    private ProductosClientFeign clientFeign;

    @Override
    public Pedido crearPedido(Long id, int cantidad) {
        Producto producto = clientFeign.buscar(id);
        return new Pedido(producto, cantidad);
    }
}
