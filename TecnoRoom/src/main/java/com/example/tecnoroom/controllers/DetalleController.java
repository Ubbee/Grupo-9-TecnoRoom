package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.DetalleOrden;
import com.example.tecnoroom.entities.Orden;
import com.example.tecnoroom.entities.Producto;
import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("tecnoRoom/detalle")
public class DetalleController extends BaseControllerImpl<DetalleOrden, DetalleServiceImpl>{

    @Autowired
    ProductoService productoService;
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    OrdenService ordenService;

    @Autowired
    DetalleService detalleService;

    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    Orden orden = new Orden();

    @PostMapping("/cart")
    public String addCart(Model model, @RequestParam Long id, @RequestParam Integer cantidad, HttpSession session) throws Exception {
        try {
            Usuario usuario = usuarioService.findById(Long.parseLong(session.getAttribute("idUsuario").toString()));
            DetalleOrden detalleOrden = new DetalleOrden();
            Producto producto = productoService.findById(id);
            double sumaTotal = 0;
            Date fecha = new Date();

            detalleOrden.setFecha(fecha);
            detalleOrden.setCantidad(cantidad);
            detalleOrden.setPrecio(producto.getPrecio());
            detalleOrden.setTotal(producto.getPrecio()*cantidad);
            detalleOrden.setNombreProducto(producto.getNombre());
            detalleOrden.setProducto(producto);
            producto.setStock((short) (producto.getStock()-cantidad));



            Long idProducto = producto.getId();
            boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId() == idProducto);
            if(!ingresado){
                detalles.add(detalleOrden);
                usuario.addProducto(producto);
                usuario.setProductos(usuario.getProductos());
                producto.setUsuario(usuario);
            }
            sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
            orden.setTotal(sumaTotal);
            orden.setDetalleOrden(detalleOrden);
            if(orden.getUsuario() == null){
                orden.setUsuario(usuario);
                usuario.addOrden(orden);
            }


            usuarioService.update(usuario, usuario.getId());
            productoService.update(producto,producto.getId());
            System.out.println("hello my id is " + usuario.getId());
            System.out.println("i have" +usuario.getProductos().size() + " productos");
            model.addAttribute("cart",detalles);
            model.addAttribute("orden",orden);

            return "usuario/carrito";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/deleteCart/{id}")
    public String deleteCart(Model model,@PathVariable Long id){
        try {
            List<DetalleOrden> detallesAUX = new ArrayList<DetalleOrden>();

            for(DetalleOrden detalleOrden : detalles){
                if(detalleOrden.getProducto().getId() != id){
                    detallesAUX.add(detalleOrden);
                }
            }

            detalles = detallesAUX;

            double sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
            orden.setTotal(sumaTotal);

            model.addAttribute("cart",detalles);
            model.addAttribute("orden",orden);

            return "usuario/carrito";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/getCart")
    public String getCart(Model model, HttpSession session){
        try {

            model.addAttribute("cart",detalles);
            model.addAttribute("orden",orden);

            model.addAttribute("sesion",session.getAttribute("idUsuario"));
            return "usuario/carrito";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/order")
    public String order(Model model, HttpSession session){
        try {
            Usuario usuario = usuarioService.findById(Long.parseLong(session.getAttribute("idUsuario").toString()));

            model.addAttribute("cart",detalles);
            model.addAttribute("orden",orden);
            model.addAttribute("usuario",usuario);

            return "usuario/resumenOrden";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/saveOrder")
    public String savOrder(Model model, HttpSession session){
        try {
            Date fechaCreacion = new Date();

            orden.setFechaCreacion(fechaCreacion);
            orden.setNumero(ordenService.generarNumeroOrden());

            Usuario usuario = usuarioService.findById(Long.parseLong(session.getAttribute("idUsuario").toString()));

            orden.setUsuario(usuario);
            ordenService.save(orden);

            //guardar detalles
            for(DetalleOrden dt : detalles){
                dt.setOrden(orden);
                detalleService.save(dt);
            }

            //limpia la lista y la orden
            orden = new Orden();
            detalles.clear();


                return "redirect:/tecnoRoom/producto/home";


        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }


}
