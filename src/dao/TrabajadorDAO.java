package dao;

import model.Trabajador;

import java.util.Optional;

public interface TrabajadorDAO {
    void registrarTrabajador(Trabajador trabajador);
    Optional<Trabajador> consultarPorId(String id);
}
