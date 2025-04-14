package com.servicio.servicio_carrito.business;

import com.servicio.servicio_carrito.clients.PedidosClienteFeign;
import com.servicio.servicio_carrito.models.Carrito;
import com.servicio.servicio_carrito.models.Pedido;
import com.servicio.servicio_carrito.persistence.CarritosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoBSImpl implements ICarritoBS{

    @Autowired
    private CarritosDAO dao;

    @Autowired
    private PedidosClienteFeign clienteFeign;

    @Override
    public Carrito crear(String usuario) {
        Carrito carrito = consultar(usuario);

        // solo creo el carrito si no existe
        if (carrito == null) {
            carrito = new Carrito();
            carrito.setUsuario(usuario);
            carrito = dao.save(carrito);
        }

        return carrito;
    }

    @Override
    public Carrito agregarPedido(Long id, Integer cantidad, String usuario) {
        Pedido pedido = clienteFeign.crearPedido(id, cantidad);
        Carrito carrito = consultar(usuario);
        carrito.getContenido().add(pedido);
        double importe = carrito.getImporte() + (pedido.getProducto().getPrecio() * cantidad);
        carrito.setImporte(importe);
        return dao.save(carrito);
    }

    @Override
    public Carrito consultar(String usuario) {
        return dao.findByUsuario(usuario);
    }

    @Override
    public Carrito eliminarPedido(Long id, String usuario) {
        Carrito carrito = consultar(usuario);
        List<Pedido> contenido = carrito.getContenido();

        Pedido encontrado = null;
        for (Pedido pedido : contenido) {
            if (id.equals(pedido.getProducto().getID())) {
                encontrado = pedido;
                break;
            }
        }

//		Pedido encontrado2 = contenido.stream()
//								.filter(pedido -> pedido.getProducto().getID().equals(id))
//								.findFirst()
//								.get();

        contenido.remove(encontrado);
        double importe = carrito.getImporte() - (encontrado.getProducto().getPrecio() * encontrado.getCantidad());
        carrito.setImporte(importe);
        return dao.save(carrito);

    }
}
