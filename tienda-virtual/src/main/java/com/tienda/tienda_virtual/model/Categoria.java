/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.model;

/**
 *
 * @author macpro
 */


import java.util.List;

public class Categoria {
    private String nombre;
    private List<Subcategoria> subcategorias;

    // Constructor
    public Categoria(String nombre, List<Subcategoria> subcategorias) {
        this.nombre = nombre;
        this.subcategorias = subcategorias;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }
}

class Subcategoria {
    private String nombre;

    public Subcategoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

