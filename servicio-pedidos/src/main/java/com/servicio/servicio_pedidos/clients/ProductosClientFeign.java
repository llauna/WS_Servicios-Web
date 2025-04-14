package com.servicio.servicio_pedidos.clients;

import com.servicio.servicio_pedidos.models.Producto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@Service
@FeignClient(name = "servicio-productos")
public interface ProductosClientFeign {

    @GetMapping("/buscar/{codigo}")
    public Producto buscar(@PathVariable(name = "codigo") Long id);
}
