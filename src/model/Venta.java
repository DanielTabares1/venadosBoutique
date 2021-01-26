package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
public class Venta {

    private  Date fecha;

    private int cantidad;

    private int precio;
    // Atributos que representan las relaciones con otras clases
    private Producto producto;

    private Trabajador trabajador;

    private Cliente cliente;

    private boolean suficiente;

    public Venta(Date fecha, Producto producto, Trabajador trabajador, Cliente cliente, int cantidad) {
        this.fecha = fecha;
        this.producto = producto;
        this.trabajador = trabajador;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.precio=cantidad* producto.getPrecio();
        if (cantidad<=producto.getCantidad()){
            this.suficiente=true;
            producto.setCantidad(producto.getCantidad()-cantidad);
        }
        else if (cantidad>producto.getCantidad() && cantidad>(producto.getCantidad()+(producto.getTela().getCantidad()/producto.getCantidadTela()))){
            this.suficiente=false;
            ////////correo al proveedor
        }
        else {
            this.suficiente=true;
            int faltan=cantidad-producto.getCantidad();
            producto.setCantidad(0);
            producto.getTela().setCantidad(producto.getTela().getCantidad()-(producto.getCantidadTela()*faltan));

        }
    }

    public Date getFecha() {        return fecha;    }

    public void setFecha(Date fecha) {        this.fecha = fecha;    }

    public int getCantidad() {        return cantidad;    }

    public void setCantidad(int cantidad) {        this.cantidad = cantidad;    }

    public int getPrecio() {        return precio;    }

    public void setPrecio(int precio) {        this.precio = precio;    }

    public Producto getProducto() {        return producto;    }

    public void setProducto(Producto producto) {        this.producto = producto; }

    public Trabajador getTrabajador() {        return trabajador; }

    public void setTrabajador(Trabajador trabajador) {        this.trabajador = trabajador; }

    public Cliente getCliente() {        return cliente;    }

    public void setCliente(Cliente cliente) {        this.cliente = cliente; }

    public boolean isSuficiente() {        return suficiente;    }

    public void setSuficiente(boolean suficiente) {        this.suficiente = suficiente;    }
}




