package co.edu.poli.examen.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.examen.Model.Producto;
import co.edu.poli.examen.Repository.ProductoRepository;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    public Producto obtenerProductoPorId(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto actualizarProducto(Producto producto) {
        Producto productoExistente = productoRepository.findById(producto.getId()).orElse(null);
        if (productoExistente == null) {
            return null;
        }
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        return productoRepository.save(productoExistente);
    }

    public Producto eliminarProducto(String id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            productoRepository.delete(producto);
        }
        return producto;
    }
}
