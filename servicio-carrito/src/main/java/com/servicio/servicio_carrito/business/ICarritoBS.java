package com.servicio.servicio_carrito.business;

import com.servicio.servicio_carrito.models.Carrito;

public interface ICarritoBS {
    Carrito crear(String usuario);
    Carrito agregarPedido(Long id, Integer cantidad, String usuario);
    Carrito consultar (String usuario);
    Carrito eliminarPedido(Long id, String usuario);
}
