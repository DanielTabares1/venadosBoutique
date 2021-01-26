package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.io.IOException;

public class ContenedorPrincipalController {

    @FXML
    private BorderPane contenedorPrincipal;

    public void btnRegistrarProveedor_action() throws IOException {
        Parent ventanaRegistroProveedores = FXMLLoader.load(getClass().getResource("../view/registrar-proveedor.fxml"));
        this.contenedorPrincipal.setCenter(ventanaRegistroProveedores);
    }
    public void btnRegistrarCliente_action() throws IOException {
        Parent ventanaRegistroClientes = FXMLLoader.load(getClass().getResource("../view/registrar-cliente.fxml"));
        this.contenedorPrincipal.setCenter(ventanaRegistroClientes);
    }
    public void btnRegistrarTrabajador_action() throws IOException {
        Parent ventanaRegistroTrabajadores = FXMLLoader.load(getClass().getResource("../view/registrar-trabajador.fxml"));
        this.contenedorPrincipal.setCenter(ventanaRegistroTrabajadores);
    }
    public void btnRegistrarTela_action() throws IOException {
        Parent ventanaRegistroTelas = FXMLLoader.load(getClass().getResource("../view/registrar-tela.fxml"));
        this.contenedorPrincipal.setCenter(ventanaRegistroTelas);
    }
    public void btnRegistrarProducto_action() throws IOException {
        Parent ventanaRegistroProductos = FXMLLoader.load(getClass().getResource("../view/registrar-producto.fxml"));
        this.contenedorPrincipal.setCenter(ventanaRegistroProductos);
    }
    public void btnRegistrarVenta_action() throws IOException {
        //Parent ventanaRegistroVentas = FXMLLoader.load(getClass().getResource("../view/registrar-venta.fxml"));
        //this.contenedorPrincipal.setCenter(ventanaRegistroVentas);
    }
    public void btnRevisarEstado_action() throws IOException {
        //Parent ventanaRegistroProductos = FXMLLoader.load(getClass().getResource("../view/registrar-producto.fxml"));
        //this.contenedorPrincipal.setCenter(ventanaRegistroProductos);
    }

    public void btnCreditos_action() {

        JOptionPane.showMessageDialog(null, "Desarrollado por Grupo7");

        //System.exit(0);
    }
}
