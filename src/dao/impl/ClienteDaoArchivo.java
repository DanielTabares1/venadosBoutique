package dao.impl;

import bsn.ClienteBsn;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import dao.ClienteDAO;
import model.Cliente;

import java.io.*;
import java.util.Optional;

public class ClienteDaoArchivo implements ClienteDAO {

    @Override
    public void registrarCliente(Cliente cliente) {
        FileWriter writer;
        try{
            writer = new FileWriter("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Clientes.txt",true);
            String registro = (cliente.getNombre()+","+cliente.getId()+","+cliente.getTelefono()+","+cliente.getCorreo());
            writer.write(registro+"\n");
            writer.close();
        } catch (IOException e){
            return;
        }
    }

    @Override
    public Optional<Cliente> consultarPorId(String id) {
        FileReader reader;
        BufferedReader reader1;
        try {
            reader = new FileReader("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Clientes.txt");
            reader1 = new BufferedReader(reader);
            String linea = reader1.readLine();
            if (linea == null) {
                return Optional.empty();
            }
            String[] elementos = linea.split(",");
            Optional<Cliente> op = Optional.empty();

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
                op = Optional.of(new Cliente(id,elementos[0],elementos[2],elementos[3]));
            }
            return op;

        } catch (IOException e) {
            System.out.println("no había archivo");
            return Optional.empty();
        }

    }
}
