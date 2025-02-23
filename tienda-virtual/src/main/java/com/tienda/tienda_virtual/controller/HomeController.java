/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.controller;

import com.tienda.tienda_virtual.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    // 🔥 Novedades (Index)
    @GetMapping("/")
    public String novedades(Model model) {
        List<Producto> productos = Arrays.asList(
            new Producto("Nike Ja 1", 700000, "Nike", 15, 1L, true, "/images/nike-ja-1.jpeg"),
            new Producto("Nike Lebron Witness 8", 600000, "Nike", 10, 2L, true, "/images/lebron-witness-8.png"),
            new Producto("Nike Kevin Durant", 500000, "Nike", 8, 3L, true, "/images/kd.png")
        );
        model.addAttribute("productos", productos);
        return "index"; // Vista de Novedades
    }

    // 👞 Zapatos para Hombre
    @GetMapping("/hombre")
    public String zapatosHombre(Model model) {
        List<Producto> productos = Arrays.asList(
            new Producto("Nike Air Max Hombre", 650000, "Nike", 12, 4L, true, "/images/air-max-hombre.jpeg"),
            new Producto("Adidas UltraBoost Hombre", 720000, "Adidas", 8, 5L, true, "/images/ultraboost-hombre.jpeg")
        );
        model.addAttribute("productos", productos);
        return "hombre";
    }

    // 👠 Zapatos para Mujer
    @GetMapping("/mujer")
    public String zapatosMujer(Model model) {
        List<Producto> productos = Arrays.asList(
            new Producto("Nike Air Max Mujer", 640000, "Nike", 10, 6L, true, "/images/air-max-mujer.jpeg"),
            new Producto("Adidas UltraBoost Mujer", 700000, "Adidas", 7, 7L, true, "/images/ultraboost-mujer.jpeg")
        );
        model.addAttribute("productos", productos);
        return "mujer";
    }
}






