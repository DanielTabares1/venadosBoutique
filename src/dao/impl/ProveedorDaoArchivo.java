package dao.impl;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import dao.ProveedorDAO;
import model.Proveedor;

import java.util.Optional;

public class ProveedorDaoArchivo implements ProveedorDAO {
    @Override
    public void registrarProveedor(Proveedor proveedor) {
        //todo guardar registro en archivo
        System.out.println(proveedor.getNombre());
        System.out.println(proveedor.getId());
        System.out.println(proveedor.getCelular());
        System.out.println(proveedor.getEmpresa());
        System.out.println(proveedor.getCiudad());
        System.out.println(proveedor.getCorreo());
    }

    @Override
    public Optional<Proveedor> consultarPorId(String id) {
        //todo verificar existencia del proveedor en archivo
        return Optional.empty();
    }
}
