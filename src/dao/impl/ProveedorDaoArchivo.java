package dao.impl;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import dao.ProveedorDAO;
import model.Cliente;
import model.Proveedor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class ProveedorDaoArchivo implements ProveedorDAO {
    @Override
    public void registrarProveedor(Proveedor proveedor) {
        FileWriter writer;
        try{
            writer = new FileWriter("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Proveedores.txt",true);
            String registro = (proveedor.getNombre()+","+proveedor.getId()+","+proveedor.getEmpresa()+","+proveedor.getCelular()+","+proveedor.getCiudad()+","+proveedor.getCorreo());
            writer.write(registro+"\n");
            writer.close();
        } catch (IOException e){
            return;
        }
    }

    @Override
    public Optional<Proveedor> consultarPorId(String id) {
        FileReader reader;
        BufferedReader reader1;
        try {
            reader = new FileReader("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Proveedores.txt");
            reader1 = new BufferedReader(reader);
            String linea = reader1.readLine();
            if (linea == null) {
                return Optional.empty();
            }
            String[] elementos = linea.split(",");
            Optional<Proveedor> op = Optional.empty();

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
                op = Optional.of(new Proveedor(id,elementos[0],elementos[2],elementos[3],elementos[4],elementos[5]));
            }
            return op;

        } catch (IOException e) {
            System.out.println("no había archivo");
            return Optional.empty();
        }
    }
}
