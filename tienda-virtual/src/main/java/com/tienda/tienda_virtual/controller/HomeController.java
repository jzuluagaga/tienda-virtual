/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Arrays;
import com.tienda.tienda_virtual.model.Producto;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        List<Producto> productos = Arrays.asList(
            new Producto("Nike Air Max", 120.00, "/images/nike-ja-1.jpeg"),
            new Producto("Adidas Ultraboost", 140.00, "/images/adidas_ultraboost.jpg"),
            new Producto("Puma RS-X", 110.00, "/images/puma_rsx.jpg"),
            new Producto("Reebok Classic", 90.00, "/images/reebok_classic.jpg"),
            new Producto("New Balance 550", 130.00, "/images/newbalance_550.jpg"),
            new Producto("Converse Chuck Taylor", 70.00, "/images/converse_ct.jpg")
        );

        model.addAttribute("productos", productos);
        return "index";
    }
}




