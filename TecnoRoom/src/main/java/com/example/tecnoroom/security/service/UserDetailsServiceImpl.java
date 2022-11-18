package com.example.tecnoroom.security.service;

import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.services.UsuarioService;
import com.example.tecnoroom.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public UsuarioServiceImpl usuarioService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByMail(mail).orElseThrow(()-> new UsernameNotFoundException(mail));
        return UsuarioPrincipal.build(usuario);
    }
}
