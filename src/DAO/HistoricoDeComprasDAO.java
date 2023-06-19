package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Entidades.Historico;
import Entidades.Vendas;

public class HistoricoDeComprasDAO  {

    private static final String FILENAME = "historico.dat";

    public static void adicionarItem(Historico historico) {
        ArrayList<Historico> historicos = listarHistorico();
        historicos.add(historico);

        salvar(historicos);
    }

    public static List<Historico> exibirHistoricoComprador(String cpf) {
        ArrayList<Historico> historicos = listarHistorico();
        List<Historico> listaHistoricos = new ArrayList<>();

        for (Historico historico: historicos) {
            if (historico.getCpf().equals(cpf)) {
                listaHistoricos.add(historico);
            }
        }

        return listaHistoricos;
    }

    public static ArrayList<Historico> listarHistorico() {
        ArrayList<Historico> historicos = new ArrayList<>();

        File file = new File(FILENAME);

        if(!file.exists()) return historicos;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                ArrayList<?> list = (ArrayList<?>) obj;
                for (Object item: list) {
                    if (item instanceof Historico) {
                        historicos.add((Historico) item);
                    }
                }
            }
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return historicos;
    }

    private static void salvar(ArrayList<Historico> historicos) {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(historicos);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
