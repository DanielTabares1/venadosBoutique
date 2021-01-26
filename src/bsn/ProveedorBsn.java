package bsn;

import dao.ProveedorDAO;
import dao.impl.ProveedorDAOList;
import model.Proveedor;

public class ProveedorBsn {

    private ProveedorDAO proveedorDAO;


    public ProveedorBsn(){
        this.proveedorDAO = new ProveedorDAOList();

    }

    public void  registrarProveedor(Proveedor proveedor){
        //validad id unico
        this.proveedorDAO.registrarProveedor(proveedor);


    }

}
