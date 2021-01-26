package dao.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import dao.ClienteDAO;
import model.Cliente;

import java.util.Optional;

public class ClienteDaoArchivo implements ClienteDAO {

    @Override
    public void registrarCliente(Cliente cliente) {
        //todo guardar datos en archivo
        System.out.println(cliente.getNombre());
        System.out.println(cliente.getId());
        System.out.println(cliente.getCorreo());
        System.out.println(cliente.getTelefono());
    }

    @Override
    public Optional<Cliente> consultarPorId(String id) {
        //todo validar existencia del cliente en archivo
        return Optional.empty();
    }
}
