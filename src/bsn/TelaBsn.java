package bsn;

import bsn.exception.TelaYaRegistradaException;
import dao.TelaDao;
import dao.impl.TelaDAOArchivo;
import model.Tela;

import java.util.Optional;

public class TelaBsn {

    private TelaDao telaDao;

    public TelaBsn(){
        this.telaDao = new TelaDAOArchivo();
    }
    public void registrarTela(Tela tela) throws TelaYaRegistradaException {
        Optional<Tela> telaOptional = this.telaDao.consultar(tela);
        if(telaOptional.isPresent()){
            throw new TelaYaRegistradaException();
        }
        else{
            this.telaDao.registrarTela(tela);
        }
    }
}
