package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.services.ProductoService;
import com.example.tecnoroom.services.UsuarioServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/cliente")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{

  @Autowired
  private ProductoService productoService;

  @GetMapping("/registro")
  public String home(Model model) {
    try {

      model.addAttribute("usuario", usuario);
      return "indexRegister";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "Error";


    }
