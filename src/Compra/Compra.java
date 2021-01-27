package Compra;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Compra {
    
    public SimpleStringProperty nombreProducto = new SimpleStringProperty();
    public SimpleStringProperty cantidad = new SimpleStringProperty();
    public SimpleIntegerProperty costoUnitario = new SimpleIntegerProperty();
    public SimpleStringProperty costoTotal = new SimpleStringProperty();
    
    
    public String getNombreProducto(){
        return nombreProducto.get();
    }
    
    public String getcantidad(){
        return cantidad.get();
    }
    
    public Integer getcostoUnitario (){
        return costoUnitario.get();
    }
    
    public String getcostoTotal(){
        return costoTotal.get();
    }
    
}