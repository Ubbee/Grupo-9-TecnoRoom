package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.DetalleOrden;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
import com.example.tecnoroom.repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends BaseServiceImpl<DetalleOrden, Long>  implements DetalleService{

    @Autowired
    private DetalleRepository detalleRepository;


    public DetalleServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
}
