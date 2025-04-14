package com.servicio.servicio_pedidos.business;

import com.servicio.servicio_pedidos.models.Pedido;

public interface IPedidoService {
    Pedido crearPedido(Long id, int cantidad);

}
