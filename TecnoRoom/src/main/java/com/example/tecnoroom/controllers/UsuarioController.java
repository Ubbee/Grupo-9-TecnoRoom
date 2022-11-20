package com.example.tecnoroom.controllers;

import com.example.tecnoroom.entities.Producto;

import com.example.tecnoroom.entities.Usuario;
import com.example.tecnoroom.services.ProductoService;
import com.example.tecnoroom.services.UsuarioService;
import com.example.tecnoroom.services.UsuarioServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;


@Controller
@CrossOrigin("*")
@RequestMapping("tecnoRoom/usuario")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProductoService productoService;


    BCryptPasswordEncoder bCryp = new BCryptPasswordEncoder();

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
            return "usuario/indexLogin";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }

    @PostMapping("/save")
    public String save(Model model,Usuario usuario,HttpSession session) {
        try {
            usuario.setRol("USER");
            usuario.setPassword(bCryp.encode(usuario.getPassword()));
            System.out.println(usuario.getId());
            usuarioService.save(usuario);
            session.setAttribute("idUsuario",usuario.getId());
            System.out.println(usuario.getId());
            System.out.println(session.getAttribute("idUsuario"));
            return "redirect:/tecnoRoom/producto/home";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }

    /*@PostMapping("/save")
    public String save(String mail, String password, String nombre, String apellido, String direccion, String departamento, String provincia
    ) {
        try {
            ModelAndView mv = new ModelAndView();
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setDireccion(direccion);
            usuario.setDepartamento(departamento);
            usuario.setProvincia(provincia);
            usuario.setPassword(passwordEncoder.encode(password));
            Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
            Set<Rol> roles = new HashSet<>();
            roles.add(rolUser);
            usuario.setRoles(roles);
            usuarioService.save(usuario);
            mv.setViewName("/login");
            mv.addObject("registroOK", "Cuenta creada, " + usuario.getNombreUsuario() + ", ya puedes iniciar sesión");
            return mv;
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }*/

//obsoleto
//    @PostMapping("/update/{id}")
//    public String addToCart(Model model, Usuario usuario, @PathVariable("id") long id){
//        try {
//            usuario = usuarioService.findById(usuario.getId());
//            System.out.println(usuario.getNombre());
//            Producto producto = productoService.findById(id);
//            usuario.addProducto(producto);
//            return "redirect:/tecnoRoom/producto/home";
//        } catch (Exception e) {
//            model.addAttribute("Error", e.getMessage());
//            return "Error";
//        }
//    }

    @PostMapping("/acceder")
    public String acceder(Model model, HttpSession session,Usuario usuario){
        try {
            System.out.println(usuario.getMail());
            String password = usuario.getPassword();
            usuario = usuarioService.findByMail(usuario.getMail());
            System.out.println("USUARIO: "+ usuario.getNombre());
            if(usuario.getId() !=null && bCryp.matches(password, usuario.getPassword())) {

                session.setAttribute("idUsuario", usuario.getId());
                session.setAttribute("mailUsuario", usuario.getMail());
                if (usuario.getRol().equals("ADMIN")) {
                    return "administrador/homeAdmin";
                } else {
                    return "redirect:/tecnoRoom/producto/home";
                }
            }
            return "redirect:/tecnoRoom/usuario/login";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }

    @GetMapping("/logout")
    public String logOut(Model model, HttpSession session){
        try {
            session.removeAttribute("idUsuario");
            return "redirect:/tecnoRoom/producto/home";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "Error";
        }
    }
    @GetMapping("/perfil")
    public String perfil(Model model, HttpSession session){
        try {
            //Optional<Usuario> user = usuarioService.fin(session.getAttribute("emailUsuario").toString());
            Usuario usuario = usuarioService.findById(Long.parseLong(session.getAttribute("idUsuario").toString()));
            model.addAttribute("usuario", usuario);
            //model.addAttribute("sesion",session.getAttribute("idUsuario"));
            return "usuario/indexPerfil";
        } catch (Exception e) {
            model.addAttribute("Error", e.getMessage());
            return "error";
        }
    }

}

