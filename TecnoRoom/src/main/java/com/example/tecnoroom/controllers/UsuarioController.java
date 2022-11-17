package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.services.ProductoService;
import com.example.tecnoroom.services.UsuarioService;
import com.example.tecnoroom.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("tecnoRoom/usuario")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProductoService productoService;

    @GetMapping("/registro")
    public String registro(Model model) {
        try {
            return "usuario/indexRegister";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        try {
            return "indexLogin";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }

    @PostMapping("/save")
    public String save(Model model,Usuario usuario) {
        try {
            usuario.setEsAdmin(false);
            usuarioService.save(usuario);
            return "redirect:/tecnoRoom/producto/home";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }

    @PostMapping("/update/{id}")
    public String addToCart(Model model, Usuario usuario, @PathVariable("id") long id){
        try {
            usuario = usuarioService.findById(usuario.getId());
            System.out.println(usuario.getNombre());
            Producto producto = productoService.findById(id);
            usuario.addProducto(producto);
            return "redirect:/tecnoRoom/producto/home";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }



}

