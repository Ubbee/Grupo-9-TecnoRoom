package com.example.tecnoroom.repositories;

import com.example.tecnoroom.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E,ID extends Serializable> extends JpaRepository<E,ID> {
}
