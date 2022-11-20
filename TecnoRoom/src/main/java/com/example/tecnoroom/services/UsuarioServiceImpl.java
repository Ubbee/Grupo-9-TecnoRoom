package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.repositories.BaseRepository;
import com.example.tecnoroom.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {


    public UsuarioServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Optional<Usuario> getById(long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario findByMail(String mail) {
        return usuarioRepository.findByEmail(mail);
    }

    @Override
    public Optional<Usuario> findByById(Long id) { return usuarioRepository.findById(id);
    }

    public boolean existsById(long id){
        return usuarioRepository.existsById(id);
    }

    public boolean existsByMail(String mail){
        return usuarioRepository.existsByMail(mail);
    }




}
