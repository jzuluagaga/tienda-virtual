package com.tienda.tienda_virtual.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.tienda_virtual.model.TarjetaDebito;

@Service
public class TarjetaDebitoService {
    private static final String FILE_PATH = "tarjetas.txt";
    private List<TarjetaDebito> tarjetas = new ArrayList<>();

    public TarjetaDebitoService() {
        cargarTarjetasDesdeArchivo();
    }

    // Registra una tarjeta de débito
    public boolean registrarTarjeta(TarjetaDebito tarjeta) {
        if (tarjetaExistente(tarjeta.getNumeroTarjeta())) {
            return false; // La tarjeta ya existe
        }
        tarjetas.add(tarjeta);
        guardarTarjetasEnArchivo();
        return true;
    }

    // Verifica si la tarjeta ya está registrada
    private boolean tarjetaExistente(String numeroTarjeta) {
        return tarjetas.stream().anyMatch(t -> t.getNumeroTarjeta().equals(numeroTarjeta));
    }

    // Guarda todas las tarjetas en un archivo
    private void guardarTarjetasEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (TarjetaDebito tarjeta : tarjetas) {
                writer.write(tarjeta.getNumeroTarjeta() + "," +
                        tarjeta.getTitular() + "," +
                        tarjeta.getFechaExpiracion() + "," +
                        tarjeta.getCvv() + "," +
                        tarjeta.getSaldo());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carga las tarjetas desde el archivo al iniciar
    private void cargarTarjetasDesdeArchivo() {
        File archivo = new File(FILE_PATH);
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] datos = linea.split(",");
                    if (datos.length == 5) {
                        TarjetaDebito tarjeta = new TarjetaDebito(
                                datos[0],  // Número de Tarjeta
                                datos[1],  // Titular
                                datos[2],  // Fecha Expiración
                                datos[3],  // CVV
                                Double.parseDouble(datos[4]) // Saldo
                        );
                        tarjetas.add(tarjeta);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

