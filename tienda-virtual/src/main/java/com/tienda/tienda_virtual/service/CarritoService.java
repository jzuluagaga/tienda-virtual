/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda_virtual.service;

import com.tienda.tienda_virtual.model.ItemCarrito;
import com.tienda.tienda_virtual.model.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service // Asegúrate de incluir esta anotación
public class CarritoService {
    private List<ItemCarrito> items = new ArrayList<>();

    public List<ItemCarrito> obtenerCarrito() {
        return items;
    }

    public void agregarAlCarrito(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
    }

    public void eliminarDelCarrito(Long id) {
        items.removeIf(item -> item.getProducto().getId() == id);
    }

    public void actualizarCantidad(Long id, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId() == id) {
                item.setCantidad(cantidad);
                break;
            }
        }
    }
}

