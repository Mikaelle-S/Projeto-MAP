package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import Entidades.Comprador;
import exception.CompradorNotFoundException;

public class CompradorDAO {
    private static final String FILENAME = "compradores.dat";

    // Método para cadastrar um comprador
    public static void cadastrarComprador(Comprador comprador) {
        ArrayList<Comprador> compradores = listarCompradores();

        compradores.add(comprador);

        salvar(compradores);
    }

    // Método para exibir um comprador pelo email
    public Comprador exibirComprador(String email) {
        ArrayList<Comprador> compradores = listarCompradores();
        
        for (Comprador comprador : compradores){
            if(comprador.getEmail().equals(email)){
                return comprador;
            }
        }
        return null;
    }

    // Método para buscar um comprador pelo CPF
    public static Comprador buscarComprador(String cpf) throws CompradorNotFoundException {
        ArrayList<Comprador> compradores = listarCompradores();

        for (Comprador comprador : compradores) {
            if (comprador.getCpf().equals(cpf)) {
                return comprador;
            }
        }
        throw new CompradorNotFoundException(cpf);
    }

    // Método para atualizar os dados de um comprador
    public static void atualizarComprador(Comprador compradorAtualizado) {
        ArrayList<Comprador> compradores = listarCompradores();

        for (int i = 0; i < compradores.size(); i++) {
            if (compradores.get(i).getCpf().equals(compradorAtualizado.getCpf())) {
                compradores.set(i, compradorAtualizado);
                break;
            }
        }
        salvar(compradores);
    }

    // Método para remover um comprador
    public static void removerComprador(Comprador comprador) {
        ArrayList<Comprador> compradores = listarCompradores();

        compradores.remove(comprador);

        salvar(compradores);
    }

    // Método para listar todos os compradores e carregar os dados do arquivo
    public static ArrayList<Comprador> listarCompradores() {
        ArrayList<Comprador> compradores = new ArrayList<>();

        File file = new File(FILENAME);

        if (!file.exists()) {
            return compradores;
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            compradores = (ArrayList<Comprador>) Arrays.asList((Comprador[]) ois.readObject());

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return compradores;
    }
    // Método para salvar os dados no arquivo
    private static void salvar(ArrayList<Comprador> compradores) {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(compradores);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
