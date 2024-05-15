package metodos;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            limpiarPantalla(); // Limpiar la pantalla antes de mostrar el menú
            System.out.println("Bienvenido, ¿qué acción desea realizar?");
            System.out.println("1. Mostrar lista de usuarios");
            System.out.println("2. Registrar un nuevo usuario");
            System.out.println("3. Eliminar un usuario");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de la opción: ");

            // Manejar entrada de usuario
            opcion = obtenerOpcion(scanner);

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
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

            if (opcion != 4) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt()
                scanner.nextLine(); // Esperar a que el usuario presione Enter antes de continuar
            }
        } while (opcion != 4);

        scanner.close();
    }

    private void limpiarPantalla() {
        // Imprimir 50 líneas en blanco para "limpiar" la pantalla
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private int obtenerOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.next(); // Consumir la entrada inválida
        }
        return scanner.nextInt();
    }
}
