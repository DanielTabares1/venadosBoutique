package bsn.exception;

public class ProveedorYaExisteException extends Exception{
    public ProveedorYaExisteException(){
        super("El proveedor ya está registrado");
    }
}
