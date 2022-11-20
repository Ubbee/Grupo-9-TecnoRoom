package com.example.tecnoroom.repositories;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface ProductoRepository extends BaseRepository<Producto, Long>{

//    @Query(value = "SELECT * FROM producto WHERE producto.nombre LIKE %:q%", nativeQuery = true)
//    List<Producto> findByTitle(@Param("q") String q);
        @Query(value = "SELECT * FROM producto WHERE producto.nombre LIKE %:q%", nativeQuery = true)
        List<Producto> findByTitle(@Param("q")String q);

}
