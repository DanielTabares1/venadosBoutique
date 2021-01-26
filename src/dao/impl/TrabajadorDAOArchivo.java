package dao.impl;

import dao.TrabajadorDAO;
import model.Trabajador;

import java.util.Optional;

public class TrabajadorDAOArchivo implements TrabajadorDAO {

    @Override
    public void registrarTrabajador(Trabajador trabajador) {
        //todo guardar registro en archivos
    }

    @Override
    public Optional<Trabajador> consultarPorId(String id) {
        //todo validar existencia del trabajador en archivos
        return Optional.empty();
    }
}
