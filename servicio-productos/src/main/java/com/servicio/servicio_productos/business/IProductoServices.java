package com.servicio.servicio_productos.business;

import com.servicio.servicio_productos.models.Producto;

import java.util.List;

public interface IProductoServices {

    List<Producto> consultarTodos();

    Producto buscarProducto(Long id);
}
