package controller;

import bsn.TelaBsn;
import bsn.exception.TelaYaRegistradaException;
import bsn.exception.TrabajadorYaExisteException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Tela;

public class RegistrarTelaController {
    @FXML
    private javafx.scene.control.TextField txtColor;
    @FXML
    private javafx.scene.control.TextField txtNombre;
    @FXML
    private javafx.scene.control.TextField txtMaterial;
    @FXML
    private javafx.scene.control.TextField txtCantidad;
    @FXML
    private javafx.scene.control.TextField txtPrecio;

    private TelaBsn telaBsn;

    public RegistrarTelaController(){
        this.telaBsn = new TelaBsn();
    }

    public void btnGuardar_action(){
        String nombreIngresado=txtNombre.getText().trim();
        String colorIngresado = txtColor.getText().trim();
        String materialIngresado = txtMaterial.getText().trim();
        int cantidadIngresada;
        int precioIngresado;

        //validacion cantidad
        if(txtCantidad.getText().isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Tela", "Resultado de la transacción", "La cantidad es requerida");
            txtCantidad.requestFocus();
            return;
        }
        try{
            cantidadIngresada = Integer.parseInt(txtCantidad.getText());
        }catch (NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Tela", "Resultado de la transacción", "La cantidad debe ser un valor numérico");
            txtCantidad.requestFocus();
            txtCantidad.clear();
            return;
        }
        //validacion precio
        if(txtPrecio.getText().isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Tela", "Resultado de la transacción", "El precio es requerido");
            txtPrecio.requestFocus();
            return;
        }
        try{
            precioIngresado = Integer.parseInt(txtPrecio.getText());
        }catch (NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Tela", "Resultado de la transacción", "El precio debe ser un valor numérico");
            txtPrecio.requestFocus();
            txtPrecio.clear();
            return;
        }
        //validacion nombre
        if(nombreIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Tela", "Resultado de la transacción", "El nombre es requerido");
            txtNombre.requestFocus();
            return;
        }
        //validacion color
        if(colorIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Tela", "Resultado de la transacción", "El color es requerido");
            txtColor.requestFocus();
            return;
        }
        //validacion material
        if(materialIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Tela", "Resultado de la transacción", "El material es requerido");
            txtMaterial.requestFocus();
            return;
        }

        Tela tela= new Tela(nombreIngresado,colorIngresado,materialIngresado,cantidadIngresada,precioIngresado);

        try{
            this.telaBsn.registrarTela(tela);
            mostrarMensaje(Alert.AlertType.INFORMATION, "Registro de Trabajador", "Resultado de la transacción", "La tela ha sido registrada con éxito");
            limpiarCampos();
        }catch (TelaYaRegistradaException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", e.getMessage());
        }
    }

    private void limpiarCampos() {
        this.txtColor.clear();
        this.txtNombre.clear();
        this.txtCantidad.clear();
        this.txtMaterial.clear();
        this.txtPrecio.clear();

    }

    private void mostrarMensaje(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
