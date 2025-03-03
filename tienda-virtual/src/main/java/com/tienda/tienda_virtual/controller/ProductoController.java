package com.tienda.tienda_virtual.controller;

import com.tienda.tienda_virtual.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    // Lista de productos simulada (esto luego podría venir de una base de datos)
    private static final List<Producto> productos = Arrays.asList(
        new Producto("Nike Ja 1", 700000, "Nike", 15, 1L, true, "/images/nike-ja-1.png"),
        new Producto("Nike Lebron Witness 8", 600000, "Nike", 10, 2L, true, "/images/lebron-witness-8.png"),
        new Producto("Nike Kevin Durant", 500000, "Nike", 8, 3L, true, "/images/kd.png")
    );

    @GetMapping("/")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping("/buscar")
    public String buscarProductos(@RequestParam("query") String query, Model model) {
        // Filtrar productos cuyo nombre contenga el término de búsqueda (ignorando mayúsculas/minúsculas)
        List<Producto> resultados = productos.stream()
            .filter(p -> p.getNombre().toLowerCase().contains(query.toLowerCase()))
            .toList();

        model.addAttribute("productos", resultados);
        return "index"; // Redirigir a la misma página con los resultados filtrados
    }

    @GetMapping("/producto/{id}")
    public String detalleProducto(@PathVariable Long id, Model model) {
        Optional<Producto> productoEncontrado = productos.stream()
            .filter(p -> p.getId() == id)
            .findFirst();

        if (productoEncontrado.isPresent()) {
            model.addAttribute("producto", productoEncontrado.get());
            return "detalle-producto";
        }

        return "redirect:/"; // Si no se encuentra, redirige al inicio
    }
}




