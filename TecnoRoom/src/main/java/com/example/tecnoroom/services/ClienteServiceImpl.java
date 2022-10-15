package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Cliente;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService{


    public ClienteServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

}
