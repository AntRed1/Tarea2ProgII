package metodos;

import entidad.usuarios.Usuarios;

/**
 *
 * @author arojas
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

    private final List<Usuarios> listaUsuarios;

    public Usuario() {
        listaUsuarios = new ArrayList<>();
    }

    /* Metodo para Mostrarlo usuarios */
    public void mostrarListaUsuarios() {
        if (listaUsuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Usuarios:\n");
        for (Usuarios usuario : listaUsuarios) {
            sb.append(usuario).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    /* Metodo para Registrar los usuarios */
    public void registrarUsuario() {
        String nombres;
        String apellidos;
        String email;
        String telefono;

        do {
            nombres = JOptionPane.showInputDialog("Ingrese su nombre:");
            apellidos = JOptionPane.showInputDialog("Ingrese su apellido:");
            email = JOptionPane.showInputDialog("Ingrese su email:");
            telefono = JOptionPane.showInputDialog("Ingrese su teléfono:");

            try {
                validarDatos(nombres, apellidos, email, telefono);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                continue;
            }

            int id = Usuarios.getProximoID();
            Usuarios nuevoUsuario = new Usuarios(id, nombres, apellidos, email, telefono);
            listaUsuarios.add(nuevoUsuario);

            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente. ID del usuario: " + id);
            break; // Salir del bucle si se registró el usuario con éxito
        } while (true); // Bucle infinito hasta que se registre un usuario válido
    }

    /*
     * Metodo para Eliminar los usuarios por ID, que se recibe de metodo
     * eliminarUsuario
     */
    public void eliminarUsuarioPorID(int idEliminar) {
        Iterator<Usuarios> iterator = listaUsuarios.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Usuarios usuario = iterator.next();
            if (usuario.getID() == idEliminar) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el ID especificado.");
        }
    }

    public void eliminarUsuario() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del usuario que desea eliminar: ");
        try {
            int idEliminar = Integer.parseInt(idStr);
            eliminarUsuarioPorID(idEliminar);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID ingresado no es válido.");
        }
    }

    /*
     * Metodo para validar los campos sean llenados y no vacios y el email no este
     * repetido
     */
    private void validarDatos(String nombres, String apellidos, String email, String telefono) {
        if (nombres.isEmpty() || apellidos.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
            throw new IllegalArgumentException("Favor completar todos los campos.");
        }

        if (!validarEmail(email)) {
            throw new IllegalArgumentException("El email ingresado no es válido. Por favor, ingrese un email válido.");
        }

        if (existeCorreo(email)) {
            throw new IllegalArgumentException(
                    "El correo ingresado ya existe en la lista de usuarios. Por favor, ingrese uno distinto.");
        }
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pattern.matcher(email);
        return mat.find();
    }

    private boolean existeCorreo(String email) {
        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
