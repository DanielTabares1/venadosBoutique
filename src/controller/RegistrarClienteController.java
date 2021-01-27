package controller;

import bsn.ClienteBsn;
import bsn.exception.ClienteYaRegistradoException;
import bsn.exception.TrabajadorYaExisteException;
import dao.ClienteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Cliente;

public class RegistrarClienteController {
    @FXML
    private javafx.scene.control.TextField txtId;
    @FXML
    private javafx.scene.control.TextField txtNombre;
    @FXML
    private javafx.scene.control.TextField txtCelular;
    @FXML
    private javafx.scene.control.TextField txtCorreo;

    //contructor
    public RegistrarClienteController (){
        this.clienteBsn = new ClienteBsn();
    }

    //conección con bsn
    private ClienteBsn clienteBsn;

    public void btnGuardar_action(){
        String idIngresado=txtId.getText().trim();
        String nombreIngresado=txtNombre.getText().trim();
        String celularIngresado=txtCelular.getText().trim();
        String correoIngresado=txtCorreo.getText().trim();

        //validaciones para id
        if(idIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Cliente", "Resultado de la transacción", "El id es requerido");
            txtId.requestFocus();
            return;
        }
        try{
            Integer.parseInt(idIngresado);
        }catch(NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Cliente", "Resultado de la transacción", "El id debe ser un valor numérico");
            txtId.requestFocus();
            txtId.clear();
            return;
        }
        //validaciones para nombres
        if(nombreIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Cliente", "Resultado de la transacción", "El nombre es requerido");
            txtNombre.requestFocus();
            return;
        }
        //validaciones para celular
        if(celularIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Cliente", "Resultado de la transacción", "El Teléfono es requerido");
            txtCelular.requestFocus();
            return;
        }
        try{
            Integer.parseInt(idIngresado);
        }catch(NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Cliente", "Resultado de la transacción", "El Teléfono debe ser un valor numérico");
            txtCelular.requestFocus();
            txtCelular.clear();
            return;
        }
        //validaciones para correo
        if(correoIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Cliente", "Resultado de la transacción", "El correo es requerido");
            txtCorreo.requestFocus();
            return;
        }

        Cliente cliente= new Cliente(idIngresado,nombreIngresado,celularIngresado,correoIngresado);

        try{
            this.clienteBsn.registrarCliente(cliente);
            mostrarMensaje(Alert.AlertType.INFORMATION, "Registro de Cliente", "Resultado de la transacción", "El Cliente ha sido registrado con éxito");
            limpiarCampos();
        }catch (ClienteYaRegistradoException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Cliente", "Resultado de la transacción", e.getMessage());
        }
    }

    private void limpiarCampos() {
        this.txtId.clear();
        this.txtNombre.clear();
        this.txtCelular.clear();
        this.txtCorreo.clear();
    }

    private void mostrarMensaje(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
