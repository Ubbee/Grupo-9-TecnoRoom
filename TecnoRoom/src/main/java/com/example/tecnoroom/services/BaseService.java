package com.example.tecnoroom.services;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E,ID extends Serializable> {

    public List<E> findAll() throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(E entity,ID id) throws Exception;

    public boolean deleteById(ID id) throws Exception;


}
