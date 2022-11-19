package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.services.ProductoService;
import com.example.tecnoroom.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping(path = "tecnoRoom/producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {

  @Autowired
  private ProductoService productoService;

  @GetMapping("/home")
  public String homeUser(Model model, HttpSession session) {
    try {
      List<Producto> productos = productoService.findAll();
      model.addAttribute("productos", productos);
      model.addAttribute("sesion",session.getAttribute("idUsuario"));

      return "usuario/home";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "Error";
    }
  }

  @GetMapping("/homeAdmin")
  public String homeAdmin(Model model) {
    try {
      List<Producto> productos = productoService.findAll();
      model.addAttribute("productos", productos);;

      return "administrador/home";
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
      return "producto/indexProd";
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
  public String editar(Model model,@PathVariable long id) {
    try {
      Producto producto = productoService.findById(id);
      model.addAttribute("product",producto);

      return "redirect:/tecnoRoom/producto/crud";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "Error";
    }
  }

  @PostMapping("/actualizar")
  public String actualizar(Model model,
                           @RequestParam long id, @RequestParam String nombre,
                           @RequestParam float precio, @RequestParam String descripcion,
                           @RequestParam String imagen, @RequestParam short stock) throws Exception {
    try {
      Producto producto= productoService.findById(id);
      producto.setNombre(nombre);
      producto.setPrecio(precio);
      producto.setImagen(imagen);
      producto.setDescripcion(descripcion);
      producto.setStock(stock);
      productoService.update(producto,id);
      return "redirect:/tecnoRoom/producto/crud";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "error";
    }
  }

  @PostMapping("/save")
  public String guardarProducto(Model model, Producto producto) throws Exception {
    try {
    productoService.save(producto);
      return "redirect:/tecnoRoom/producto/crud";
    } catch (Exception e) {
      model.addAttribute("Error", e.getMessage());
      return "error";
    }
  }



}
