/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.controller;

/**
 *
 * @author macpro
 */

import com.tienda.tienda_virtual.model.Producto;
import com.tienda.tienda_virtual.model.ItemCarrito;
import com.tienda.tienda_virtual.service.CarritoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public String verCarrito(Model model) {
        model.addAttribute("items", carritoService.obtenerCarrito());
        return "carrito"; // Asegúrate de tener "carrito.html" en "templates/"
    }

    @PostMapping("/agregar")
    public String agregarAlCarrito(
        @RequestParam String nombre, 
        @RequestParam double precio, 
        @RequestParam int cantidad, 
        @RequestParam String imagen) { // Agregar parámetro de imagen

    // Crear el objeto Producto con la imagen proporcionada
    Producto producto = new Producto(nombre, precio, "Marca X", 10, 1L, true, imagen);
    
    // Agregar el producto al carrito
    carritoService.agregarAlCarrito(producto, cantidad);
    
    // Redirigir al carrito
    return "redirect:/carrito";
}


    @PostMapping("/eliminar")
    public String eliminarDelCarrito(@RequestParam Long id) {
        carritoService.eliminarDelCarrito(id);
        return "redirect:/carrito";
    }

    @PostMapping("/actualizar")
    public String actualizarCantidad(@RequestParam Long id, @RequestParam int cantidad) {
        carritoService.actualizarCantidad(id, cantidad);
        return "redirect:/carrito";
    }
}
