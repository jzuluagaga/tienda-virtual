/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.model;

public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String telefono;
    private String contraseña;

    // Constructor
    public Usuario(String nombre, String apellido, String correo, String direccion, String telefono, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}


