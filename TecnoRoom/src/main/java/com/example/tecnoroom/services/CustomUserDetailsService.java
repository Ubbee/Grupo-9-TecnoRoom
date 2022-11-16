//package com.example.tecnoroom.services;
//
//import com.example.tecnoroom.entities.CustomUserDetails;
//import com.example.tecnoroom.entities.Usuario;
//import com.example.tecnoroom.repositories.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findByEmail(mail);
//        if ( usuario == null){
//            throw new UsernameNotFoundException("Usuario no encontrado");
//        }
//        return new CustomUserDetails(usuario);
//    }
//}
