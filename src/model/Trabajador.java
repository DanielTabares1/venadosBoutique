package model;

public class Trabajador extends Persona {

    private String direccion;

    private String celular;

    //
    private static int contadorTrabajadores;

    public Trabajador(String id, String nombre, String direccion, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.celular=celular;
        this.direccion=direccion;
        contadorTrabajadores++;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    //

    public static int getContadorTrabajadores() {
        return contadorTrabajadores;
    }


}

