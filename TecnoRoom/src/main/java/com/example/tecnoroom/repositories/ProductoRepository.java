package com.example.tecnoroom.repositories;

import com.example.tecnoroom.entities.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto,Long> {
}
