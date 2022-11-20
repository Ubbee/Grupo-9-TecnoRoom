package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.repositories.BaseRepository;
import com.example.tecnoroom.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto,Long> implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Producto findByMail(String mail) throws Exception {
        return null;
    }

    @Transactional
    public List<Producto> findByTitle(String q) throws Exception{
        try {
            List<Producto> entities = this.productoRepository.findByTitle(q);
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
