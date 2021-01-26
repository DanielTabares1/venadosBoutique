package dao.impl;

import dao.ClienteDAO;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOList implements ClienteDAO {

    private static List<Cliente> clientesDB= new ArrayList<>();

    @Override
    public void registrarCliente(Cliente cliente){
        clientesDB.add(cliente);
    }
}
