package com.servicio.servicio_productos.rest;

import com.servicio.servicio_productos.business.IProductoServices;
import com.servicio.servicio_productos.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoREST {
    @Autowired
    private IProductoServices productoServices;

    // Capturar el puerto por el que entra la peticion
    @Value("${server.port}")
    private Integer port;

    // http://localhost:8001/listar
    @GetMapping("/listar")
    public List<Producto> listar(){
        // Opcion 1
//		List<Producto> lista = productoServices.consultarTodos();
//		for (Producto producto : lista) {
//			producto.setPort(port);
//		}
//		return lista;

        // Opcion 2
        return productoServices.consultarTodos()
                .stream()
                .peek(prod -> prod.setPort(port))
                .collect(Collectors.toList());
    }

    // http://localhost:8001/buscar/3
    @GetMapping("/buscar/{codigo}")
    public Producto buscar(@PathVariable(name = "codigo") Long id) {
        Producto producto = productoServices.buscarProducto(id);
        producto.setPort(port);
        return producto;
    }
}
