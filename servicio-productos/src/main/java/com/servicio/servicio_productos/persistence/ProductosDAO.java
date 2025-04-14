package com.servicio.servicio_productos.persistence;

import com.servicio.servicio_productos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "PRODUCTOS")
public interface ProductosDAO extends JpaRepository<Producto, Long> {
}
