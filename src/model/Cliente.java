package model;

public class Cliente extends Persona {

    private String direccion;

    private String celular;

    private String ciudad;

    private String correo;

    public Cliente(String id, String nombre, String direccion, String celular, String ciudad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.celular=celular;
        this.direccion=direccion;
        this.correo=correo;
        this.ciudad=ciudad;

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

    public String getCiudad() {        return ciudad;    }

    public void setCiudad(String ciudad) {        this.ciudad = ciudad;    }

    public String getCorreo() {        return correo;    }

    public void setCorreo(String correo) {        this.correo = correo;    }
}
