package model;

public class Trabajador extends Persona {

    private String direccion;
    private String celular;
    private String usuario;
    private String contraseña;
    private static int contadorTrabajadores;

    public Trabajador(String id, String nombre, String direccion, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.usuario = nombre;
        this.contraseña = id;
        contadorTrabajadores++;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public static int getContadorTrabajadores() {
        return contadorTrabajadores;
    }


}

