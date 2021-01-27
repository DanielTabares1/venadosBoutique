package dao.impl;

import dao.TelaDao;
import model.Tela;

import java.util.Optional;

public class TelaDAOArchivo implements TelaDao {
    @Override
    public Optional<Tela> consultar(Tela tela) {
        //TODO BUSCAR EXISTENCIA DE TELA
        return Optional.empty();
    }

    @Override
    public void registrarTela(Tela tela) {
        //todo agregar a los archivos
        System.out.println(tela.getNombre());
        System.out.println(tela.getMaterial());
        System.out.println(tela.getColor());
        System.out.println(tela.getCantidad());
        System.out.println(tela.getPrecioPorMetro());
    }
}
