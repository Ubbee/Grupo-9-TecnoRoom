package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.DetalleOrden;
import com.example.tecnoroom.services.DetalleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@CrossOrigin("*")
@RequestMapping("tecnoRoom/detalle")
public class DetalleController extends BaseControllerImpl<DetalleOrden, DetalleServiceImpl>{

}
