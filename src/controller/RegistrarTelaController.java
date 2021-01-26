package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Tela;

public class RegistrarTelaController {
    @FXML
    private javafx.scene.control.TextField txtId;
    @FXML
    private javafx.scene.control.TextField txtNombre;
    @FXML
    private javafx.scene.control.TextField txtEmpresa;
    @FXML
    private javafx.scene.control.TextField txtCelular;

    @FXML
    private javafx.scene.control.TextField txtCiudad;

    public void btnGuardar_action(){
        String idIngresado=txtId.getText();
        String nombreIngresado=txtNombre.getText();
        String empresaIngresado=txtEmpresa.getText();
        int celularIngresado= Integer.parseInt(txtCelular.getText());
        int ciudadIngresado= Integer.parseInt(txtCiudad.getText());


        Tela tela= new Tela(idIngresado,nombreIngresado,empresaIngresado,celularIngresado,ciudadIngresado);

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registro de Tela");
        alert.setHeaderText("como asi");
        alert.setContentText("Se ha registrado el tela");
        alert.showAndWait();

        limpiarCampos();

    }

    private void limpiarCampos() {
        this.txtId.clear();
        this.txtNombre.clear();
        this.txtEmpresa.clear();
        this.txtCelular.clear();
        this.txtCiudad.clear();

    }


}
