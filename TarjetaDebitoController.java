package com.tienda.tienda_virtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.tienda_virtual.model.TarjetaDebito;
import com.tienda.tienda_virtual.service.TarjetaDebitoService;

@Controller
@RequestMapping("/tarjeta")
public class TarjetaDebitoController {
    private final TarjetaDebitoService tarjetaDebitoService;

    public TarjetaDebitoController(TarjetaDebitoService tarjetaDebitoService) {
        this.tarjetaDebitoService = tarjetaDebitoService;
    }

    // Mostrar formulario de registro de tarjeta
    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "tarjeta";  // Ensure this matches tarjeta.html
    }

    // Registrar una tarjeta (POST)
    @PostMapping("/registro")
    public String registrarTarjeta(
            @RequestParam String numeroTarjeta,
            @RequestParam String titular,
            @RequestParam String fechaExpiracion,
            @RequestParam String cvv,
            @RequestParam double saldo,
            Model model
    ) {
        TarjetaDebito nuevaTarjeta = new TarjetaDebito(numeroTarjeta, titular, fechaExpiracion, cvv, saldo);
        boolean registrada = tarjetaDebitoService.registrarTarjeta(nuevaTarjeta);

        if (!registrada) {
            model.addAttribute("error", "Esta tarjeta ya está registrada.");
            return "tarjeta";
        }

        model.addAttribute("mensaje", "Tarjeta registrada exitosamente.");
        return "index";
    }
}

