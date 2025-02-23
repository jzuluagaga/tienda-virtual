/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.model;

public class Talla {
    private double numero;
    private boolean disponible;
    private int stock;

    public Talla(double numero, int stock) {
        this.numero = numero;
        this.stock = stock;
        verificarDisponibilidad();
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        verificarDisponibilidad();
    }

    public void verificarDisponibilidad() {
        this.disponible = stock > 0;
    }

    public void modificarStock(int cantidad) {
        this.stock += cantidad;
        verificarDisponibilidad();
    }
}

