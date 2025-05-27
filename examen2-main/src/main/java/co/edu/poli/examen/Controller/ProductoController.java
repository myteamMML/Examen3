package co.edu.poli.examen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.examen.Model.Producto;
import co.edu.poli.examen.Services.ProductoServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    @GetMapping
    public ResponseEntity<List<Producto>> FindAll() {
        List<Producto> productos = productoServices.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> ObtenerProductoPorId(@PathVariable String id) {
        Producto producto = productoServices.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> CrearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoServices.guardarProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> ActualizarProducto(@PathVariable String id, @RequestBody Producto producto) {
        producto.setId(id);
        Producto productoActualizado = productoServices.actualizarProducto(producto);
        if (productoActualizado == null) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> EliminarProducto(@PathVariable String id) {
        Producto productoEliminado = productoServices.eliminarProducto(id);
        if (productoEliminado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoEliminado);
    }

}
