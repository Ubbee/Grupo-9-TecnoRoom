package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.services.ProductoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>{


}
