package controller;
import bsn.TrabajadorBsn;
import bsn.exception.TrabajadorYaExisteException;
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

    //constructor
    public RegistrarTrabajadorController(){
        this.trabajadorBsn = new TrabajadorBsn();
    }

    //conexion con negocio
    private TrabajadorBsn trabajadorBsn;


    public void btnGuardar_action(){
        String idIngresado=txtId.getText().trim();
        String nombreIngresado=txtNombre.getText().trim();
        String celularIngresado=txtCelular.getText().trim();
        String ciudadIngresado=txtCiudad.getText().trim();

        //validaciones para id
        if(idIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", "El id es requerido");
            txtId.requestFocus();
            return;
        }
        try{
            Integer.parseInt(idIngresado);
        }catch(NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", "El id debe ser un valor numérico");
            txtId.requestFocus();
            txtId.clear();
            return;
        }
        //validaciones para nombres
        if(nombreIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", "El nombre es requerido");
            txtNombre.requestFocus();
            return;
        }
        //validaciones para celular
        if(celularIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", "El celular es requerido");
            txtCelular.requestFocus();
            return;
        }
        try{
            Integer.parseInt(idIngresado);
        }catch(NumberFormatException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", "El celular debe ser un valor numérico");
            txtCelular.requestFocus();
            txtCelular.clear();
            return;
        }
        //validaciones para direccion
        if(ciudadIngresado.isEmpty()){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", "la dirección es requerida");
            txtCiudad.requestFocus();
            return;
        }

        Trabajador trabajador= new Trabajador(idIngresado,nombreIngresado,ciudadIngresado,celularIngresado);

        try{
            this.trabajadorBsn.registrarTrabajador(trabajador);
            mostrarMensaje(Alert.AlertType.INFORMATION, "Registro de Trabajador", "Resultado de la transacción", "El trabajador ha sido registrado con éxito");
            limpiarCampos();
        }catch (TrabajadorYaExisteException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", e.getMessage());
        }

        try{
            this.trabajadorBsn.registrarTrabajador(trabajador);
            mostrarMensaje(Alert.AlertType.INFORMATION, "Registro de Trabajador", "Resultado de la transacción", "El trabajador ha sido registrado con éxito");
            limpiarCampos();
        }catch (TrabajadorYaExisteException e){
            mostrarMensaje(Alert.AlertType.ERROR, "Registro de Trabajador", "Resultado de la transacción", e.getMessage());
        }
    }

    private void limpiarCampos() {
        this.txtId.clear();
        this.txtNombre.clear();
        this.txtCelular.clear();
        this.txtCiudad.clear();
    }

    // método para validar un conjunto de Strings: null o vacío
    private boolean validarCampos(String... campos) {
        boolean sonValidos = true;
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                sonValidos = false;
                break;
            }
        }
        return sonValidos;
    }

    private void mostrarMensaje(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }



}
