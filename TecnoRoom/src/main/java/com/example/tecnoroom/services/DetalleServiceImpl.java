package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.DetalleOrden;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
<<<<<<< HEAD
import com.example.tecnoroom.repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends BaseServiceImpl<DetalleOrden, Long>  implements DetalleService{

    @Autowired
    private DetalleRepository detalleRepository;

=======
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends BaseServiceImpl<DetalleOrden,Long> implements DetalleService{
>>>>>>> 8604d0cd062124d2f0e72ac1ede749f36ee27447

    public DetalleServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
}
