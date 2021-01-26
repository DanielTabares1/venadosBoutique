package model;

public class Administrador extends Persona {

    private String contraseña;
    private String usuario;

    //constructor
    public Administrador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = nombre;
        this.contraseña = id;
    }

    //getters y setters
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}

