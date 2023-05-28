package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Entidades.Produto;
import exception.ProdutoNotFoundException;

public class ProdutoDAO {
    private static final String FILENAME = "produtos.dat";
   
    // Método para cadastrar um produto
    public static void cadastrarProduto(Produto produto) {
        List<Produto> produtos = listarProdutos();

        produtos.add(produto);

        salvar(produtos);
    }

    // Método para exibir um produto
    public static void exibirProduto(Produto produto) {
        System.out.println(produto);
    }

    // Método para buscar um produto
    public static Produto buscarProduto(String nome) throws ProdutoNotFoundException {
        List<Produto> produtos = listarProdutos();

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        throw new ProdutoNotFoundException(nome);
    }

    // Método para atualizar os dados de um produto
    public static void atualizarProduto(Produto produtoAtualizado) {
        List<Produto> produtos = listarProdutos();

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(produtoAtualizado.getNome())) {
                produtos.set(i, produtoAtualizado);
                break;
            }
        }
        salvar(produtos);
    }

     // Método para remover um produto
    public static void removerProduto(Produto produto) {
        List<Produto> produtos = listarProdutos();

        produtos.remove(produto);

        salvar(produtos);
    }

     // Método para listar todos os produtos e carregar os dados do arquivo
    public static List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();

        File file = new File(FILENAME);

        if (!file.exists()) {
            return produtos;
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            produtos = (List<Produto>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    private static void salvar(List<Produto> produtos) {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(produtos);

            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}