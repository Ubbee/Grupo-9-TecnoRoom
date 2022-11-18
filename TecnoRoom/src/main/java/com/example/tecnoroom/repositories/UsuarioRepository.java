package com.example.tecnoroom.repositories;


import com.example.tecnoroom.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long>{

    @Query("SELECT u FROM Usuario u WHERE u.mail = ?1")
    public Usuario findByEmail(String mail);


    Optional<Usuario> findByMail(String mail);

    boolean existsByMail(String mail);

}
