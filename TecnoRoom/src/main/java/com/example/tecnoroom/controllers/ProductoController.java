package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.services.ProductoService;
import com.example.tecnoroom.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping(path = "tecnoRoom/producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {

  @Autowired
  private ProductoService productoService;

  @GetMapping("/home")
  public String home(Model model) {
    try {
      List<Producto> productos = productoService.findAll();
      model.addAttribute("productos", productos);
      return "indexShop";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "Error";
    }
  }


  @GetMapping("/detalle/{id}")
  public String producto(Model model, @PathVariable("id") long id) {
    try {
      Producto producto = productoService.findById(id);
      model.addAttribute("producto", producto);
      return "indexProd";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "Error";
    }
  }

  @GetMapping("/crud")
  public String crud(Model model) {
    try {
      List<Producto> productos = productoService.findAll();
      model.addAttribute("products",productos);
      return "administrador/CRUD";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "Error";
    }
  }

  @GetMapping("/editar/{id}")
  public String editar(Model model,@PathVariable Long id) {
    try {
      Producto producto = productoService.findById(id);
      model.addAttribute("product",producto);

      return "redirect:/tecnoRoom/producto/crud";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "Error";
    }
  }

  @PostMapping("/save")
  public String guardarProducto(Model model,Producto producto) {
    try {
      productoService.save(producto);
      return "redirect:/tecnoRoom/producto/crud";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "error";
    }
  }

}
