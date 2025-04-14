package com.servicio.servicio_productos.business;

import com.servicio.servicio_productos.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.servicio.servicio_productos.persistence.ProductosDAO;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoServices {
    @Autowired
    private ProductosDAO dao;

    @Override
    public List<Producto> consultarTodos() {
        return dao.findAll();
    }

    @Override
    public Producto buscarProducto(Long id) {
        return dao.findById(id).orElse(new Producto());
    }
}
