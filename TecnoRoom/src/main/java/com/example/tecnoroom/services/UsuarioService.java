package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Usuario;

import java.util.Optional;

public interface UsuarioService extends BaseService<Usuario,Long>{
    public Usuario findByMail(String mail);
    public Optional<Usuario> findByById(Long id);
}
