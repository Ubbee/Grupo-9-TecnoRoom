package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Orden;
import com.example.tecnoroom.services.OrdenServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/ordenes")
public class OrdenController extends BaseControllerImpl<Orden, OrdenServiceImpl>{



}
