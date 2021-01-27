package model;

public abstract class Persona {
    //variables de la clase
    protected String nombre;
    protected String id;

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

