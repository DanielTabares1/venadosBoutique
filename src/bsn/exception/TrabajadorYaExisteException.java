package bsn.exception;

public class TrabajadorYaExisteException extends Exception{
    public TrabajadorYaExisteException(){
        super("Ya existe un trabajador con el id ingresado");
    }

}
