package model;

import java.util.LinkedList;
import java.util.List;

public class Tela {

    private String nombre;

    private String color;

    private String material;

    private int cantidad;

    private int precioPorMetro;

    // Atributos que representan las relaciones con otras clases
    private List<Proveedor> proveedores;

    public Tela(String nombre, String color, String material, int cantidad, int precioPorMetro) {
        this.nombre=nombre;
        this.color = color;
        this.material = material;
        this.cantidad = cantidad;
        this.precioPorMetro = precioPorMetro;
        // se crea una lista vacía de materiales
        proveedores = new LinkedList();
    }



    public void agregarProveedor(Proveedor proveedor){this.proveedores.add(proveedor);}

    public List<Proveedor> getProveedores() {        return proveedores;    }

    public void setProveedores(List<Proveedor> proveedores) {        this.proveedores = proveedores; }

    public String getColor() {        return color;    }

    public void setColor(String color) {        this.color = color;    }

    public String getMaterial() {        return material;    }

    public void setMaterial(String material) {        this.material = material; }

    public int getCantidad() {        return cantidad; }

    public void setCantidad(int cantidad) {        this.cantidad = cantidad; }

    public int getPrecioPorMetro() {        return precioPorMetro; }

    public void setPrecioPorMetro(int precioPorMetro) {        this.precioPorMetro = precioPorMetro; }

    public String getNombre() {        return nombre;    }

    public void setNombre(String nombre) {        this.nombre = nombre;    }

    public Boolean buscarPorNombre(String nombre){
       if (this.getNombre().equals(nombre)){
           return true;
       }
        return false;
    }
}
