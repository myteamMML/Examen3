package co.edu.poli.examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.examen.Model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
