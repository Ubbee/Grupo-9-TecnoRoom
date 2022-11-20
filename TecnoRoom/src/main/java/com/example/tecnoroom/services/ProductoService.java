package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductoService extends BaseService<Producto,Long>{
    public List<Producto> findByTitle(String q) throws Exception;
}
