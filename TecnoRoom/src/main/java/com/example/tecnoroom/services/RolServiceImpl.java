package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Rol;
import com.example.tecnoroom.enums.RolNombre;
import com.example.tecnoroom.repositories.BaseRepository;
import com.example.tecnoroom.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolServiceImpl extends BaseServiceImpl<Rol,Long> implements RolService{
    public RolServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    public RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public boolean existsByRolNombre(RolNombre rolNombre){
        return rolRepository.existsByRolNombre(rolNombre);
    }

}
