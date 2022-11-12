package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.services.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/cliente")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{



}
