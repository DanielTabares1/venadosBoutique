package dao.impl;

import dao.TrabajadorDAO;
import model.Cliente;
import model.Trabajador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class TrabajadorDAOArchivo implements TrabajadorDAO {

    @Override
    public void registrarTrabajador(Trabajador trabajador) {
        FileWriter writer;
        try{
            writer = new FileWriter("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Trabajadores.txt",true);
            String registro = (trabajador.getNombre()+","+trabajador.getId()+","+trabajador.getDireccion()+","+trabajador.getCelular());
            writer.write(registro+"\n");
            writer.close();
        } catch (IOException e){
            return;
        }
    }

    @Override
    public Optional<Trabajador> consultarPorId(String id) {
        FileReader reader;
        BufferedReader reader1;
        try {
            reader = new FileReader("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Trabajadores.txt");
            reader1 = new BufferedReader(reader);
            String linea = reader1.readLine();
            if (linea == null) {
                return Optional.empty();
            }
            String[] elementos = linea.split(",");
            Optional<Trabajador> op = Optional.empty();

            while (!elementos[1].equals(id) && linea!=null) {
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
            if(elementos[1].equals(id)){
                op = Optional.of(new Trabajador(id,elementos[0],elementos[2],elementos[3]));
            }
            return op;

        } catch (IOException e) {
            System.out.println("no había archivo");
            return Optional.empty();
        }
    }
}
