package DAO;

import java.io.*;
import java.util.ArrayList;

import exception.LojaNotFoundException;
import exception.LojaJaExistenteException;

import Entidades.Loja;

public class LojaDAO {
    private static final String FILENAME = "lojas.dat";
    
    // Método para cadastrar loja
    public static void cadastrar(Loja loja) throws LojaJaExistenteException {
        ArrayList<Loja> lojas = listarLoja();
        // Verificar se a loja já existe
        if (existeLoja(loja.getCpfCnpj())) {
            throw new LojaJaExistenteException(loja.getCpfCnpj());
        }

        lojas.add(loja);

        salvar(lojas);
    }

    private static boolean existeLoja(String cpfCnpj) {
        ArrayList<Loja> lojas = listarLoja();

        for (Loja loja : lojas) {
            if (loja.getCpfCnpj().equals(cpfCnpj)) {
                return true;
            }
        }
        return false;
    }

    // Método para exibir uma loja
    public static void exibir(Loja loja) {
        System.out.println(loja);
    }

    // Método para buscar uma loja pelo cpfCnpj
    public static Loja buscar(String cpfCnpj) throws LojaNotFoundException{
        ArrayList<Loja> lojas = listarLoja();

        for (Loja loja : lojas){
            if(loja.getCpfCnpj().equals(cpfCnpj)){
                return loja;
            }
        }
        throw new LojaNotFoundException(cpfCnpj);
        
    }

    // Método para atualizar os dados de uma loja
    public static void atualizar(Loja lojaAtualizada) {
        ArrayList<Loja> lojas = listarLoja();

        for (int i = 0; i < lojas.size(); i++){
            if(lojas.get(i).getCpfCnpj().equals(lojaAtualizada.getCpfCnpj())){
                lojas.set(i, lojaAtualizada);
                break;
            }
        }
        salvar(lojas);
    }

    // Método para remover uma loja
    public static void remover(Loja loja) {
        ArrayList<Loja> lojas = listarLoja();

        lojas.remove(loja);

        salvar(lojas);
    }

    // Método para listar todas as lojas e carregar os dados do arquivo
    public static ArrayList<Loja> listarLoja() {
        ArrayList<Loja> lojas = new ArrayList<>();

        File file = new File(FILENAME);

        if(!file.exists()){
            return lojas;
        }
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                ArrayList<?> list = (ArrayList<?>) obj;
                for (Object item : list) {
                    if (item instanceof Loja) {
                        lojas.add((Loja) item);
                    }
                }
            }
            ois.close();
            fis.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return lojas;
    }

    // Método para salvar os dados no arquivo
    private static void salvar(ArrayList<Loja> lojas) {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(lojas);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
