package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Administrador;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;

public class AdministradorServiceImpl extends BaseServiceImpl<Administrador,Long> implements administradorService{

    public AdministradorServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
}
