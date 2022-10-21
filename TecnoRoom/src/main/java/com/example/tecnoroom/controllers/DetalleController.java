package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.DetalleOrden;
import com.example.tecnoroom.services.BaseServiceImpl;
import com.example.tecnoroom.services.DetalleService;
import com.example.tecnoroom.services.DetalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/detalles")
public class DetalleController extends BaseControllerImpl<DetalleOrden, DetalleServiceImpl>{


}
