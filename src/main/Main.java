package main;

import DAO.CompradorDAO;
import DAO.LojaDAO;
import DAO.ProdutoDAO;
import Entidades.Comprador;
import Entidades.Loja;
import Entidades.Produto;
import exception.CompradorNotFoundException;
import exception.LojaNotFoundException;
import exception.ProdutoNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar uma loja
            Loja loja1 = new Loja("Loja 1", "loja1@example.com", "senha123", "123456789", "Endereço 1");
            Loja loja2 = new Loja("Loja 2", "loja2@example.com", "senha456", "987654321", "Endereço 2");

            // Cadastrar as lojas
            LojaDAO.cadastrar(loja1);
            LojaDAO.cadastrar(loja2);

            // Listar todas as lojas
            System.out.println("=== Listagem de Lojas ===");
            for (Loja loja : LojaDAO.listarLoja()) {
                System.out.println(loja);
            }
            System.out.println();

            // Buscar uma loja pelo CPF/CNPJ
            String cnpj = "123456789";
            Loja lojaEncontrada = LojaDAO.buscar(cnpj);
            System.out.println("=== Loja Encontrada ===");
            System.out.println(lojaEncontrada);
            System.out.println();

            // Criar um comprador
            Comprador comprador1 = new Comprador("Comprador 1", "comprador1@example.com", "senha789", "CPF 1", "Endereço 3");
            Comprador comprador2 = new Comprador("Comprador 2", "comprador2@example.com", "senha012", "CPF 2", "Endereço 4");

            // Cadastrar os compradores
            CompradorDAO.cadastrarComprador(comprador1);
            CompradorDAO.cadastrarComprador(comprador2);

            // Listar todos os compradores
            System.out.println("=== Listagem de Compradores ===");
            for (Comprador comprador : CompradorDAO.listarCompradores()) {
                System.out.println(comprador);
            }
            System.out.println();

            // Buscar um comprador pelo CPF
            String cpf = "CPF 1";
            Comprador compradorEncontrado = CompradorDAO.buscarComprador(cpf);
            System.out.println("=== Comprador Encontrado ===");
            System.out.println(compradorEncontrado);
            System.out.println();

            // Criar um produto
            Produto produto1 = new Produto("Produto 1", "Eletrônicos", "Marca 1", "Descrição 1", 99.99, 10);
            Produto produto2 = new Produto("Produto 2", "Livros", "Marca 2", "Descrição 2", 49.99, 5);

            ProdutoDAO.cadastrarProduto(produto1);
            ProdutoDAO.cadastrarProduto(produto2);;

            // Listar todos os produtos
            System.out.println("=== Listagem de Produtos da Loja ===");
            for (Produto produto : ProdutoDAO.listarProdutos()) {
                System.out.println(produto);
            }

            // Buscar produto por nome
            System.out.println("=== Buscar Produto por Nome ===");
            Produto buscandoProduto= ProdutoDAO.buscarProduto("Produto 1");
            System.out.println(buscandoProduto);
        
           
        }catch (LojaNotFoundException e) {
            e.printStackTrace();
        }catch (CompradorNotFoundException e) {
            e.printStackTrace();
        }catch (ProdutoNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}