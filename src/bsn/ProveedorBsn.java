package bsn;

import bsn.exception.ProveedorYaExisteException;
import dao.ProveedorDAO;
import dao.impl.ProveedorDAOList;
import dao.impl.ProveedorDaoArchivo;
import model.Proveedor;

import java.util.Optional;

public class ProveedorBsn {

    private ProveedorDAO proveedorDAO;

    public ProveedorBsn(){  this.proveedorDAO = new ProveedorDaoArchivo(); }

    public void  registrarProveedor(Proveedor proveedor) throws ProveedorYaExisteException {
        Optional<Proveedor> proveedorOptional = this.proveedorDAO.consultarPorId(proveedor.getId());
        if(proveedorOptional.isPresent()){
            throw new ProveedorYaExisteException();
        }
        else {
            this.proveedorDAO.registrarProveedor(proveedor);
        }
    }
}
