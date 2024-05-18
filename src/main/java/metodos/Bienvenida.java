package metodos;

import javax.swing.*;

/**
 *
 * @author arojas
 */

public class Bienvenida {

    private final Usuario usuario;

    public Bienvenida(Usuario usuario) {
        this.usuario = usuario;
    }

    public void iniciarInterfaz() {
        int opcion;

        do {
            limpiarPantalla();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    usuario.mostrarListaUsuarios();
                    break;
                case 2:
                    usuario.registrarUsuario();
                    break;
                case 3:
                    usuario.eliminarUsuario();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
            }

            if (opcion != 4) {
                JOptionPane.showMessageDialog(null, "\nPresione Enter para continuar...");
            }
        } while (opcion != 4);
    }

    private void limpiarPantalla() {
        // Este método ya no sería necesario con JOptionPane
    }

    private int obtenerOpcion() {
        String opcionStr = JOptionPane.showInputDialog(
                "Bienvenido, ¿qué acción desea realizar?\n"
                + "1. Mostrar lista de usuarios\n"
                + "2. Registrar un nuevo usuario\n"
                + "3. Eliminar un usuario\n"
                + "4. Salir\n"
                + "Ingrese el número de la opción: ");

        try {
            return Integer.parseInt(opcionStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.");
            return obtenerOpcion(); // Volver a intentar obtener la opción
        }
    }
}
