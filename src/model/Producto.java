package model;

import java.util.LinkedList;
import java.util.List;

public class Producto {

    private String nombre;

    private int cantidad;

    private int precio;

    private char talla;

    private int cantidadTela;

    private int horasTrabajo;

    // Atributos que representan las relaciones con otras clases
    private Tela tela;

    public Producto(String nombre, int cantidad, char talla, int cantidadTela, int horasTrabajo, Tela tela) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.talla = talla;
        this.cantidadTela = cantidadTela;
        this.horasTrabajo = horasTrabajo;
        this.tela = tela;
        this.precio = tela.getPrecioPorMetro() * cantidadTela * horasTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char getTalla() {
        return talla;
    }

    public void setTalla(char talla) {
        this.talla = talla;
    }

    public int getCantidadTela() {
        return cantidadTela;
    }

    public void setCantidadTela(int cantidadTela) {
        this.cantidadTela = cantidadTela;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }
}

