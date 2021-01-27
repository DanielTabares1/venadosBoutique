package bsn;

import bsn.exception.ClienteYaRegistradoException;
import dao.ClienteDAO;
import dao.impl.ClienteDaoArchivo;
import model.Cliente;

import java.util.Optional;

public class ClienteBsn {

    private ClienteDAO clienteDAO;

    public ClienteBsn(){
        this.clienteDAO = new ClienteDaoArchivo();
    }

    public void registrarCliente(Cliente cliente) throws ClienteYaRegistradoException {
        Optional<Cliente> clienteOptional = this.clienteDAO.consultarPorId(cliente.getId());
        if(clienteOptional.isPresent()){
            throw new ClienteYaRegistradoException();
        }
        else{
            this.clienteDAO.registrarCliente(cliente);
        }
    }
}
