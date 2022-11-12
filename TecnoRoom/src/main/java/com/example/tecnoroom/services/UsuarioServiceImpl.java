package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService{


    public UsuarioServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

}
