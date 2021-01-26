package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Cliente;

public class RegistrarClienteController {
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

    public void btnGuardar_action(){
        String idIngresado=txtId.getText();
        String nombreIngresado=txtNombre.getText();
        String empresaIngresado=txtEmpresa.getText();
        String celularIngresado=txtCelular.getText();
        String ciudadIngresado=txtCiudad.getText();
        String correoIngresado=txtCorreo.getText();

        Cliente cliente= new Cliente(idIngresado,nombreIngresado,empresaIngresado,celularIngresado,ciudadIngresado,correoIngresado);

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registro de Cliente");
        alert.setHeaderText("como asi");
        alert.setContentText("Se ha registrado el cliente");
        alert.showAndWait();

        limpiarCampos();

    }

    private void limpiarCampos() {
        this.txtId.clear();
        this.txtNombre.clear();
        this.txtEmpresa.clear();
        this.txtCelular.clear();
        this.txtCorreo.clear();
        this.txtCiudad.clear();
    }


}
