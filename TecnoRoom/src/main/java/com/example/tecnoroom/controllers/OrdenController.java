package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Orden;
import com.example.tecnoroom.services.OrdenServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("tecnoRoom/ordenes")
public class OrdenController extends BaseControllerImpl<Orden, OrdenServiceImpl>{



}
