package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Trabajador;

public class  RegistrarTrabajadorController {
    @FXML
    private javafx.scene.control.TextField txtId;
    @FXML
    private javafx.scene.control.TextField txtNombre;

    @FXML
    private javafx.scene.control.TextField txtCelular;

    @FXML
    private javafx.scene.control.TextField txtCiudad;

    public void btnGuardar_action(){
        String idIngresado=txtId.getText();
        String nombreIngresado=txtNombre.getText();

        String celularIngresado=txtCelular.getText();
        String ciudadIngresado=txtCiudad.getText();


        Trabajador trabajador= new Trabajador(idIngresado,nombreIngresado,ciudadIngresado,celularIngresado);

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registro de Trabajador");
        alert.setHeaderText("como asi");
        alert.setContentText("Se ha registrado el trabajador");
        alert.showAndWait();

        limpiarCampos();

    }

    private void limpiarCampos() {
        this.txtId.clear();
        this.txtNombre.clear();

        this.txtCelular.clear();

        this.txtCiudad.clear();
    }


}
