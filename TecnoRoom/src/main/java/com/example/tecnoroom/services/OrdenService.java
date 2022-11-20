package com.example.tecnoroom.services;

import com.example.tecnoroom.entities.Orden;

public interface OrdenService extends BaseService<Orden,Long>{

    String generarNumeroOrden();

}
