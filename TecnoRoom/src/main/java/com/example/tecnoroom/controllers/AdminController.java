package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Administrador;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.services.AdminServiceImpl;
import com.example.tecnoroom.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("tecnoRoom/v1/admin")
public class AdminController extends BaseControllerImpl<Administrador, AdminServiceImpl>{

    @Autowired
    private ProductoService productoService;


    @PutMapping("/editar/{id}")
    public String editar(Model model, @PathVariable("id") Long id){
        try{
            Producto producto = productoService.findById(id);
            model.addAttribute("producto",producto);
            return "/admin/editar";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/producto/{id}")
    public String formularioProducto(Model model,@PathVariable("id")Long id){
        try {
            if(id==0){
                model.addAttribute("producto",new Producto());
            }else{
                model.addAttribute("producto",productoService.findById(id));
            }
            return "views/formulario/producto";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/producto/{id}")
    public String guardarProducto(@ModelAttribute("producto") Producto producto,Model model,@PathVariable("id") Long id){
        try {
            if(id == 0){
                productoService.save(producto);
            }else {
                productoService.update(producto,id);
            }
            return "redirect:/crud";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/crud")
    public String crudProducto(Model model){
        try {
            List<Producto> productos = productoService.findAll();
            model.addAttribute("productos", productos);
            return "views/crud";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }


}
