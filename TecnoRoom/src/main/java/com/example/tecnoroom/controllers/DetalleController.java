package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.DetalleOrden;
<<<<<<< HEAD
import com.example.tecnoroom.services.BaseServiceImpl;
import com.example.tecnoroom.services.DetalleService;
import com.example.tecnoroom.services.DetalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
=======
import com.example.tecnoroom.services.DetalleServiceImpl;
>>>>>>> 8604d0cd062124d2f0e72ac1ede749f36ee27447
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/detalles")
public class DetalleController extends BaseControllerImpl<DetalleOrden, DetalleServiceImpl>{


=======
@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/detalle")
public class DetalleController extends BaseControllerImpl<DetalleOrden, DetalleServiceImpl>{

>>>>>>> 8604d0cd062124d2f0e72ac1ede749f36ee27447
}
