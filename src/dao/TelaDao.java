package dao;

import model.Tela;

import java.util.Optional;

public interface TelaDao {
    Optional<Tela> consultar(Tela tela);

    void registrarTela(Tela tela);
}
