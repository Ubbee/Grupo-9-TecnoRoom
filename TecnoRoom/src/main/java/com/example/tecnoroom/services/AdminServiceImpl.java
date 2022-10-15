package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Administrador;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Administrador,Long> implements AdminService{

    public AdminServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }



}
