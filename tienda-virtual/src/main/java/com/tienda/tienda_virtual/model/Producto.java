/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.model;

public class Producto {
    private String nombre;
    private double precio;
    private String marca;
    private int stock;
    private long id;
    private boolean disponibilidad;
    private String imagen; // Nuevo atributo para la ruta de la imagen

    // Constructor actualizado
    public Producto(String nombre, double precio, String marca, int stock, long id, boolean disponibilidad, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.stock = stock;
        this.id = id;
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        actualizarDisponibilidad();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getImagen() { // Getter para la imagen
        return imagen;
    }

    public void setImagen(String imagen) { // Setter para la imagen
        this.imagen = imagen;
    }

    // Métodos adicionales según el UML
    public void actualizarDisponibilidad() {
        this.disponibilidad = this.stock > 0;
    }

    public void modificarStock(int cantidad) {
        this.stock += cantidad;
        actualizarDisponibilidad();
    }

    public String obtenerInformacion() {
        return "Producto: " + nombre + " | Marca: " + marca + " | Precio: $" + precio +
               " | Stock: " + stock + " | Disponible: " + (disponibilidad ? "Sí" : "No");
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            this.precio -= this.precio * (porcentaje / 100);
        }
    }

    public boolean verificarStock(int cantidad) {
        return this.stock >= cantidad;
    }
}



