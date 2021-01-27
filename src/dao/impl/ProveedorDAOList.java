package dao.impl;

import dao.ProveedorDAO;
import model.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProveedorDAOList implements ProveedorDAO {

    private static List<Proveedor> proveedoresDB= new ArrayList<>();

    @Override
    public void registrarProveedor(Proveedor proveedor){
        proveedoresDB.add(proveedor);
    }

    @Override
    public Optional<Proveedor> consultarPorId(String id) {
        return Optional.empty();
    }
}
