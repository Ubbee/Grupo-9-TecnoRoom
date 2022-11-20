package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Orden;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImpl extends BaseServiceImpl<Orden,Long> implements OrdenService{



    public OrdenServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Orden findByMail(String mail) throws Exception {
        return null;
    }
}
