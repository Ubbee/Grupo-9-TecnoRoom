package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.DetalleOrden;
import com.example.tecnoroom.entities.Orden;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.services.DetalleServiceImpl;
import com.example.tecnoroom.services.ProductoService;
import com.example.tecnoroom.services.ProductoServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("tecnoRoom/detalle")
public class DetalleController extends BaseControllerImpl<DetalleOrden, DetalleServiceImpl>{

    @Autowired
    ProductoService productoService;

    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    Orden orden = new Orden();

    @PostMapping("/cart")
    public String addCart(Model model, @RequestParam Long id, @RequestParam Integer cantidad) throws Exception {
        try {
            DetalleOrden detalleOrden = new DetalleOrden();
            Producto producto = productoService.findById(id);
            double sumaTotal = 0;

            detalleOrden.setCantidad(cantidad);
            detalleOrden.setPrecio(producto.getPrecio());
            detalleOrden.setTotal(producto.getPrecio()*cantidad);
            detalleOrden.setNombreProducto(producto.getNombre());
            detalleOrden.setProducto(producto);

            detalles.add(detalleOrden);

            sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
            orden.setTotal(sumaTotal);
            orden.setDetalleOrden(detalleOrden);

            model.addAttribute("cart",detalles);
            model.addAttribute("orden",orden);

            return "usuario/carrito";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "error";
        }
    }
}
