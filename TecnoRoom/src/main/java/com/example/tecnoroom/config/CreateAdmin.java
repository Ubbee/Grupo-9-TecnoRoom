package com.example.tecnoroom.config;

import com.example.tecnoroom.entities.Rol;
import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.enums.RolNombre;
import com.example.tecnoroom.services.RolService;
import com.example.tecnoroom.services.RolServiceImpl;
import com.example.tecnoroom.services.UsuarioService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public RolServiceImpl rolService;

    @Override
    public void run(String... args) throws Exception {
       /* Usuario usuario= new Usuario();
        String passwordEncoded = passwordEncoder.encode("admin");
        usuario.setMail("admin");
        usuario.setPassword(passwordEncoded);
        Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolAdmin);
        roles.add(rolUser);
        usuario.setRoles(roles);
        usuarioService.save(usuario);*/
    }
}
