package controller;

import com.jfoenix.controls.JFXTextField;
import dao.impl.LoginDAOArchivo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class LoginController {

    @FXML
    private JFXTextField txtId;
    private JFXTextField txtContra;

    private LoginDAOArchivo loginDAOArchivo;

    public LoginController(){
        this.loginDAOArchivo = new LoginDAOArchivo();
    }
    public void verificarUsuario(){
        String nombreIngresado = txtId.getText().trim();
        String contra = txtContra.getText().trim();

        //validaciones para contra
        if(contra.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Inicio de sesion", "Resultado de la transacción", "Contraseña es requerida");
            txtContra.requestFocus();
            return;
        }
        //validaciones para nombres
        if(nombreIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Inicio de seison", "Resultado de la transacción", "El nombre es requerido");
            txtId.requestFocus();
            return;
        }

        boolean usuarioExiste = loginDAOArchivo.verificarUsuario(nombreIngresado,contra);

        if(usuarioExiste){
            mostrarMensaje(Alert.AlertType.INFORMATION, "Inicio de seison", "Resultado de la transacción", "Inicio de sesion exitoso");
        }
        else if(!usuarioExiste){
            mostrarMensaje(Alert.AlertType.ERROR, "Inicio de sesion", "Resultado de la transacción", "Usuario no registrado.");
        }

    }

    private void mostrarMensaje(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}


