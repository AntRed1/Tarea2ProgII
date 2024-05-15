package entidad.usuarios;

/**
 *
 * @author arojas
 */
public class Usuarios {

    private static int proximoID = 1;
    private int ID;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;

    public Usuarios(String nombres, String apellidos, String email, String telefono) {
        this.ID = proximoID++;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    public Usuarios(int ID, String nombres, String apellidos, String email, String telefono) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    public static int getProximoID() {
        return proximoID;
    }

    public int getID() {
        return ID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario: \n"
                + "ID: " + ID + "\n"
                + "Nombres: " + nombres + "\n"
                + "Apellidos: " + apellidos + "\n"
                + "Email: " + email + "\n"
                + "Teléfono: " + telefono;
    }
}
