package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByMail(username);
        try {




            if (usuario != null) {
                session.setAttribute("idUsuario", usuario.getId());
                usuario = usuarioService.findById(Long.parseLong(session.getAttribute("idUsuario").toString()));

                return User.builder().username(usuario.getNombre()).password(usuario.getPassword()).roles(usuario.getRol()).build();


            } else {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return User.builder().username(usuario.getNombre()).password(usuario.getPassword()).roles(usuario.getRol()).build();


    }
}
