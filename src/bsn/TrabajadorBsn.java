package bsn;

import bsn.exception.TrabajadorYaExisteException;
import dao.TrabajadorDAO;
import dao.impl.TrabajadorDAOArchivo;
import model.Trabajador;

import java.util.Optional;

public class TrabajadorBsn {

    private TrabajadorDAO trabajadorDAO;

    public TrabajadorBsn(){
        this.trabajadorDAO = new TrabajadorDAOArchivo();
    }

    public void registrarTrabajador(Trabajador trabajador) throws TrabajadorYaExisteException {
        Optional<Trabajador> trabajadorOptional = this.trabajadorDAO.consultarPorId(trabajador.getId());
        if(trabajadorOptional.isPresent()){
            throw new TrabajadorYaExisteException();
        }
        else{
            this.trabajadorDAO.registrarTrabajador(trabajador);
        }
    }
}
