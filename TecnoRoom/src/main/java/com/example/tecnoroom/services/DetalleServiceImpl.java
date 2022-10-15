package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.DetalleOrden;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends BaseServiceImpl<DetalleOrden,Long> implements DetalleService{

    public DetalleServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
}
