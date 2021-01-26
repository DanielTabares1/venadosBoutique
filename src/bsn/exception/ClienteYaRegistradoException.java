package bsn.exception;

public class ClienteYaRegistradoException extends Exception{
    public ClienteYaRegistradoException(){
        super("El cliente ya está registrado");
    }
}
