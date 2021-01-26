package dao.impl;

import dao.ProveedorDAO;
import model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOList implements ProveedorDAO {

    private static List<Proveedor> proveedoresDB= new ArrayList<>();

    @Override
    public void registrarProveedor(Proveedor proveedor){
        proveedoresDB.add(proveedor);
    }
}
