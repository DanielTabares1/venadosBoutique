package model;



public class Proveedor extends Persona {

    private String empresa;

    private String celular;

    private String ciudad;

    private String correo;



    public Proveedor(String id, String nombre, String empresa, String celular, String ciudad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.celular=celular;
        this.empresa=empresa;
        this.correo=correo;
        this.ciudad=ciudad;

    }




    public String getEmpresa() {        return empresa;    }

    public void setEmpresa(String empresa) {        this.empresa = empresa; }

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
