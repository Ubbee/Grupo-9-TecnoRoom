package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.services.ProductoService;
import com.example.tecnoroom.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>{
    @Autowired
    private ProductoService productoService;

    @GetMapping("/home")
    public String home(Model model){
        try{
            List<Producto> productos = productoService.findAll();
            model.addAttribute("productos",productos);
            return "/admin/home";
        }catch (Exception e){
            model.addAttribute("Error",e.getMessage());
            return "Error";
        }
    }
}