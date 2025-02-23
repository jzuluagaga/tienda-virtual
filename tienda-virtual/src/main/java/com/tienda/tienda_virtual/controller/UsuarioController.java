/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.controller;

import com.tienda.tienda_virtual.model.Usuario;
import com.tienda.tienda_virtual.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    // Mostrar formulario de registro (GET)
    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "registro"; // Asegúrate de que exista registro.html en templates
    }

    // Procesar formulario de registro (POST)
    @PostMapping("/registro")
    public String registrarUsuario(
        @RequestParam String nombre,
        @RequestParam String apellido,
        @RequestParam String correo,
        @RequestParam String direccion,
        @RequestParam String telefono,
        @RequestParam String contraseña,
        Model model
    ) {
        Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, direccion, telefono, contraseña);
        boolean registrado = usuarioService.registrarUsuario(nuevoUsuario);
    
        if (!registrado) {
            model.addAttribute("error", "El correo ya está registrado.");
            return "registro";
        }

        model.addAttribute("mensaje", "Registro exitoso. Ahora puedes iniciar sesión.");
        return "login";
    }
    
    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        return "login"; // Devuelve la página de inicio de sesión
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String correo, @RequestParam String contraseña, Model model) {
        System.out.println("Intentando iniciar sesión con correo: " + correo);
        Usuario usuario = usuarioService.iniciarSesion(correo, contraseña);
        if (usuario != null) {
            System.out.println("Inicio de sesión exitoso para: " + usuario.getNombre());
            model.addAttribute("nombreUsuario", usuario.getNombre());
            return "bienvenida";
        } else {
            System.out.println("Inicio de sesión fallido");
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "login";
        }
    }

    @GetMapping("/bienvenida")
    public String mostrarBienvenida(Model model) {
        return "bienvenida";  // Asegúrate de que "bienvenida.html" está en templates.
    }
}



