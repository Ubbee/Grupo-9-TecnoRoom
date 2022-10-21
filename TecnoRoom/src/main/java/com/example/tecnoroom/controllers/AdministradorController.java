package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Administrador;
import com.example.tecnoroom.services.AdministradorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/administrador")
public class AdministradorController extends BaseControllerImpl<Administrador, AdministradorServiceImpl>{
}
