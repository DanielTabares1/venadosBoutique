package dao.impl;

import dao.LoginDAO;
import model.Trabajador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class LoginDAOArchivo implements LoginDAO {
    @Override
    public boolean verificarUsuario(String nombre, String contra) {
        FileReader reader;
        BufferedReader reader1;
        try {
            reader = new FileReader("C:/Users/HP/IdeaProjects/entrega-final/src/resources/Users.txt");
            reader1 = new BufferedReader(reader);
            String linea = reader1.readLine();
            if (linea == null) {
                return false;
            }
            String[] elementos = linea.split(",");

            while (!elementos[1].equals(contra) && !elementos[0].equals(nombre) &&linea!=null) {
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
            if(elementos[1].equals(contra)&&elementos[0].equals(nombre)){
                return true;
            }

        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
