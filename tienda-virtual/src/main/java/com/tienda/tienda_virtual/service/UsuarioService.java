package com.tienda.tienda_virtual.service;

import com.tienda.tienda_virtual.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static final String FILE_PATH = "usuarios.txt";

    // Constructor que carga los usuarios desde el archivo al iniciar la aplicación
    public UsuarioService() {
        cargarUsuariosDesdeArchivo();
    }

    // Registrar un nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        if (correoExistente(usuario.getCorreo())) {
            return false; // El correo ya está registrado
        }
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña())); // Cifrar la contraseña
        usuarios.add(usuario);
        guardarUsuariosEnArchivo();
        return true; // Usuario registrado exitosamente
    }

    // Validar inicio de sesión
    public Usuario iniciarSesion(String correo, String contraseña) {
        for (Usuario usuario : usuarios) {
            // Verificamos que la contraseña ingresada coincida con la cifrada
            if (usuario.getCorreo().equals(correo) && passwordEncoder.matches(contraseña, usuario.getContraseña())) {
                return usuario; // Usuario válido
            }
        }
        return null; // Usuario no encontrado
    }

    // Verificar si el correo ya está registrado
    public boolean correoExistente(String correo) {
        return usuarios.stream().anyMatch(u -> u.getCorreo().equalsIgnoreCase(correo));
    }

    // Guardar usuarios en un archivo
    private void guardarUsuariosEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getNombre() + "," + usuario.getApellido() + "," + usuario.getCorreo() + "," +
                        usuario.getDireccion() + "," + usuario.getTelefono() + "," + usuario.getContraseña());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar usuarios desde el archivo al iniciar la aplicación
    private void cargarUsuariosDesdeArchivo() {
        File archivo = new File(FILE_PATH);
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] datos = linea.split(",");
                    if (datos.length == 6) {
                        Usuario usuario = new Usuario(
                                datos[0], // Nombre
                                datos[1], // Apellido
                                datos[2], // Correo
                                datos[3], // Dirección
                                datos[4], // Teléfono
                                datos[5]  // Contraseña cifrada
                        );
                        usuarios.add(usuario);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



