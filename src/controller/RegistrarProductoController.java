package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Producto;
import model.Tela;

public class RegistrarProductoController {
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
        int nombreIngresado= Integer.parseInt(txtNombre.getText());
        char empresaIngresado=txtEmpresa.getText().charAt(1);
        int celularIngresado= Integer.parseInt(txtCelular.getText());
        int ciudadIngresado= Integer.parseInt(txtCiudad.getText());

        String correoIngresado=txtCorreo.getText();
        Tela aux = new Tela("NN","NN","NN",1,1);

        Producto proveedor= new Producto(idIngresado,nombreIngresado,empresaIngresado,celularIngresado,ciudadIngresado,aux);

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registro de Producto");
        alert.setHeaderText("como asi");
        alert.setContentText("Se ha registrado el producto");
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
