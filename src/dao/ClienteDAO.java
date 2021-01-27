package dao;

import model.Cliente;

import java.util.Optional;

public interface ClienteDAO {

    void registrarCliente(Cliente cliente);

    Optional<Cliente> consultarPorId(String id);
}
