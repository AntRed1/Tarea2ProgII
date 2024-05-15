package domain;

import metodos.Bienvenida;
import metodos.Usuario;

/**
 *
 * @author arojas
 */
public class First {

    public static void main(String[] args) {
        try {
            // Crear una instancia de Usuario
            Usuario usuario = new Usuario();

            // Crear una instancia de Bienvenida y pasarle la instancia de Usuario
            Bienvenida bienvenida = new Bienvenida(usuario);

            // Iniciar la interfaz de usuario
            bienvenida.iniciarInterfaz();
        } catch (Exception e) {
            // Manejar cualquier excepción y mostrar un mensaje al usuario
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }
}
