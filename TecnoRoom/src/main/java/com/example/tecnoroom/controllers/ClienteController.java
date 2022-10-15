package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Cliente;
import com.example.tecnoroom.services.ClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/{id}")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{



}
