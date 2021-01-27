package dao.impl;

import dao.TelaDao;
import model.Cliente;
import model.Tela;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class TelaDAOArchivo implements TelaDao {
    @Override
    public Optional<Tela> consultar(Tela tela) {
        FileReader reader;
        BufferedReader reader1;
        try {
            reader = new FileReader("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Telas.txt");
            reader1 = new BufferedReader(reader);
            String linea = reader1.readLine();
            if (linea == null) {
                return Optional.empty();
            }
            String[] elementos = linea.split(",");
            Optional<Tela> op = Optional.empty();

            while ((!elementos[0].equals(tela.getNombre())&&!elementos[1].equals(tela.getColor())&&!elementos[2].equals(tela.getMaterial())) && linea!=null) {
                linea = reader1.readLine();
                if(linea==null){
                    break;
                }
                else{
                    elementos = linea.split(",");
                }
            }
            reader1.close();
            reader.close();
            if(elementos[0].equals(tela.getNombre())&&elementos[1].equals(tela.getColor())&&elementos[2].equals(tela.getMaterial())){
                op = Optional.of(new Tela(elementos[0],elementos[1],elementos[2],Integer.parseInt(elementos[3]),Integer.parseInt(elementos[4])));
            }
            return op;

        } catch (IOException e) {
            System.out.println("no había archivo");
            return Optional.empty();
        }
    }

    @Override
    public void registrarTela(Tela tela) {
        FileWriter writer;
        try{
            writer = new FileWriter("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Telas.txt",true);
            String registro = (tela.getNombre()+","+tela.getColor()+","+tela.getMaterial()+","+tela.getCantidad()+","+tela.getPrecioPorMetro());
            writer.write(registro+"\n");
            writer.close();
        } catch (IOException e){
            return;
        }
    }
}
