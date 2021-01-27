package controller;

import bsn.ProveedorBsn;
import bsn.exception.ProveedorYaExisteException;
import bsn.exception.TrabajadorYaExisteException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Proveedor;

import java.awt.*;

public class RegistrarProveedorController {
    @FXML
    private javafx.scene.control.TextField txtId;
    @FXML
    private javafx.scene.control.TextField txtNombre;
    @FXML
    private javafx.scene.control.TextField txtEmpresa;
    @FXML
    private javafx.scene.control.TextField txtCelular;
    @FXML
    private javafx.scene.control.TextField txtCorreo;
    @FXML
    private javafx.scene.control.TextField txtCiudad;

    public RegistrarProveedorController(){
        this.proveedorBsn = new ProveedorBsn();
    }

    private ProveedorBsn proveedorBsn;

    public void btnGuardar_action(){
        String idIngresado=txtId.getText().trim();
        String nombreIngresado=txtNombre.getText().trim();
        String empresaIngresado=txtEmpresa.getText().trim();
        String celularIngresado=txtCelular.getText().trim();
        String ciudadIngresado=txtCiudad.getText().trim();
        String correoIngresado=txtCorreo.getText().trim();



        //validacion de id
        if(idIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "El id es requerido");
            txtId.requestFocus();
            return;
        }
        try{
            Integer.parseInt(idIngresado);
        }catch(NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "El id debe ser un valor numérico");
            txtId.requestFocus();
            txtId.clear();
            return;
        }
        //validacion de nombre
        if(nombreIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "El nombre es requerido");
            txtNombre.requestFocus();
            return;
        }
        //validacion de empresa
        if(empresaIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "El nombre de la empresa es requerido");
            txtEmpresa.requestFocus();
            return;
        }
        //validacion de celular
        if(celularIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "El Teléfono es requerido");
            txtCelular.requestFocus();
            return;
        }
        try{
            Integer.parseInt(celularIngresado);
        }catch(NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "El Teléfono debe ser un valor numérico");
            txtCelular.requestFocus();
            txtCelular.clear();
            return;
        }
        //validacion de ciudad
        if(ciudadIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "La ciudad es requerida");
            txtCiudad.requestFocus();
            return;
        }
        //validacion de correo
        if(correoIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", "El correo es requerido");
            txtCorreo.requestFocus();
            return;
        }

        Proveedor proveedor= new Proveedor(idIngresado,nombreIngresado,empresaIngresado,celularIngresado,ciudadIngresado,correoIngresado);

        try{
            this.proveedorBsn.registrarProveedor(proveedor);
            mostrarMensaje(Alert.AlertType.INFORMATION, "Registro de Proveedor", "Resultado de la transacción", "El Proveedor ha sido registrado con éxito");
            limpiarCampos();
        }catch (ProveedorYaExisteException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Proveedor", "Resultado de la transacción", e.getMessage());
        }
    }

    private void limpiarCampos() {
        this.txtId.clear();
        this.txtNombre.clear();
        this.txtEmpresa.clear();
        this.txtCelular.clear();
        this.txtCorreo.clear();
        this.txtCiudad.clear();
    }

    private void mostrarMensaje(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
