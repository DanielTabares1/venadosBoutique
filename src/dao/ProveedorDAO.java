package dao;

import model.Proveedor;

import java.util.Optional;

public interface ProveedorDAO {

    void registrarProveedor(Proveedor proveedor);

    Optional<Proveedor> consultarPorId(String id);
}
