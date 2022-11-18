package com.example.tecnoroom.repositories;

import com.example.tecnoroom.entities.Rol;
import com.example.tecnoroom.enums.RolNombre;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends BaseRepository<Rol,Long>{

    Optional<Rol> findByRolNombre(RolNombre rolNombre);

    boolean existsByRolNombre(RolNombre rolNombre);
}
