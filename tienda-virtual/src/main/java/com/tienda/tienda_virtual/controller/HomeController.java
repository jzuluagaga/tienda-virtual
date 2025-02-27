/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Página de inicio (index)
    
    public String novedades(Model model) {
        return "index"; // Carga la página de novedades sin productos
    }

    // Página de Hombre
    @GetMapping("/hombre")
    public String zapatosHombre() {
        return "hombre";
    }

    // Página de Mujer
    @GetMapping("/mujer")
    public String zapatosMujer() {
        return "mujer";
    }
}







