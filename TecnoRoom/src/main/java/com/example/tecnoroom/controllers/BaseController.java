package com.example.tecnoroom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E,ID extends Serializable>{

    public ResponseEntity<?> getAll();

    public ResponseEntity<?> getById(@PathVariable ID id);

    public ResponseEntity<?> save(@RequestBody E entity);

    public ResponseEntity<?> update(@RequestBody E entity,@PathVariable ID id);

    public ResponseEntity<?> deleteById(@PathVariable ID id);
}
