package model;

public class Administrador extends Persona {

    private String contraseña;

    //constructor

    public Administrador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getContraseña() { return contraseña;    }

    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

}

