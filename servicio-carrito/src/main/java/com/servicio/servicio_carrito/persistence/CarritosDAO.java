package com.servicio.servicio_carrito.persistence;

import com.servicio.servicio_carrito.models.Carrito;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarritosDAO extends MongoRepository<Carrito, String> {
    public Carrito findByUsuario(String usuario);
}
