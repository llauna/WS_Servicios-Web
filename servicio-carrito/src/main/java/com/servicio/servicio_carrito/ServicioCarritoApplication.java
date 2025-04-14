package com.servicio.servicio_carrito;

import com.servicio.servicio_carrito.persistence.CarritosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@EnableFeignClients
public class ServicioCarritoApplication implements CommandLineRunner {

	@Autowired
	private CarritosDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(ServicioCarritoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Eliminar todos los carritos
		dao.deleteAll();
	}
}
