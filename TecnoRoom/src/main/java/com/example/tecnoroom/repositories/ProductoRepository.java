package com.example.tecnoroom.repositories;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto,Long> {



}
