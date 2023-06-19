package DAO;

import Entidades.*;
import exception.LojaJaExistenteException;
import exception.ProdutoNotFoundException;

import java.util.List;
import java.util.Scanner;

public class FachadaDAO {

    public static void run() {
        try {
            Loja loja1 = new Loja("Loja 1", "loja1@example.com", "senha123", "123456789", "Endereço 1");
            LojaDAO.cadastrar(loja1);

            Comprador comprador1 = new Comprador("Comprador 1", "comprador1@example.com", "senha789", "CPF 1", "Endereço 3");
            CompradorDAO.cadastrarComprador(comprador1);

            Produto produto1 = new Produto("Camisa Polo", Itens.VESTUARIO, "Marca 1", "Camisa polo de algodão", 99.99, 10);
            Produto produto2 = new Produto("Smartphone", Itens.ELETRÔNICO, "Marca 2", "Smartphone com câmera de alta resolução", 49.99, 5);
            Produto produto3 = new Produto("Sapato Social", Itens.VESTUARIO, "Marca 3", "Sapato social de couro", 89.99, 8);
            Produto produto4 = new Produto("Televisão", Itens.ELETRÔNICO, "Marca 4", "Televisão de 55 polegadas com resolução 4K", 999.99, 3);
            Produto produto6 = new Produto("Notebook", Itens.ELETRÔNICO, "Marca 6", "Notebook com processador i7 e 16GB de RAM", 1499.99, 2);
            Produto produto7 = new Produto("Calça Jeans", Itens.VESTUARIO, "Marca 7", "Calça jeans masculina", 79.99, 15);
            Produto produto8 = new Produto("Fone de Ouvido", Itens.ELETRÔNICO, "Marca 8", "Fone de ouvido sem fio com cancelamento de ruído", 299.99, 5);
            Produto produto9 = new Produto("Geladeira", Itens.ELETRÔNICO, "Marca 9", "Geladeira frost-free com capacidade de 400 litros", 1999.99, 4);
            Produto produto10 = new Produto("Tênis Esportivo", Itens.VESTUARIO, "Marca 10", "Tênis esportivo com amortecimento de impacto", 129.99, 6);

            ProdutoDAO.cadastrarProduto(produto1);
            ProdutoDAO.cadastrarProduto(produto2);
            ProdutoDAO.cadastrarProduto(produto3);
            ProdutoDAO.cadastrarProduto(produto4);
            ProdutoDAO.cadastrarProduto(produto6);
            ProdutoDAO.cadastrarProduto(produto7);
            ProdutoDAO.cadastrarProduto(produto8);
            ProdutoDAO.cadastrarProduto(produto9);
            ProdutoDAO.cadastrarProduto(produto10);

            exibirMenu(comprador1);

        } catch (LojaJaExistenteException | ProdutoNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void exibirListagemProdutos() {
        System.out.println();
        System.out.println("=== Listagem de Produtos da Loja ===");
        for (Produto produto : ProdutoDAO.listarProdutos()) {
            System.out.println(produto);
        }
        System.out.println();
    }

    private static void exibirMenu(Comprador comprador) throws ProdutoNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        exibirListagemProdutos();

        do {
            System.out.println();
            System.out.println("=== Menu ===");
            System.out.println("1 - Adicionar item ao carrinho");
            System.out.println("2 - Ver carrinho");
            System.out.println("3 - Opções de Usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    adicionarItemCarrinho(comprador);
                    break;
                case 2:
                    verCarrinho(comprador);
                    break;
                case 3:
                    opcoesUsuario(comprador);
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 0);
    }

    private static void adicionarItemCarrinho(Comprador comprador) throws ProdutoNotFoundException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite no nome do produto: ");
            String nome = scanner.nextLine();
            Produto produto = ProdutoDAO.buscarProduto(nome);
            System.out.println("Digite quantidade do produto: ");
            int quantidade = scanner.nextInt();
            Pedidos pedidos = new Pedidos(produto, quantidade);
            comprador.adicionarPedidoAoCarrinho(pedidos);
            System.out.println("Opção 'Adicionar item ao carrinho' selecionada.");
        } catch (ProdutoNotFoundException e) {
            System.err.println("Produto não encontrado " + e);
        } catch (Exception e) {
            System.err.println("Ocorreru um erro inesperado " + e);
        }
    }

    private static void verCarrinho(Comprador comprador) throws ProdutoNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Carrinho de Compras ===");
            List<Pedidos> carrinho = comprador.getCarrinhoDeCompras();
            for (Pedidos pedidos : carrinho) {
                System.out.println(pedidos);
            }

            System.out.println("\nOpções:");
            System.out.println("1 - Comprar carrinho");
            System.out.println("2 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    comprarCarrinho(comprador);
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal...");
                    exibirMenu(comprador);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 2);

    }

    private static void comprarCarrinho(Comprador comprador) throws ProdutoNotFoundException {
        List<Pedidos> carrinho = comprador.getCarrinhoDeCompras();
        double valorTotal = 0.0;

        for (Pedidos pedido : carrinho) {
            valorTotal += pedido.getValor();
        }

        System.out.println("Valor total do carrinho: R$" + valorTotal);

        System.out.println("Deseja confirmar a compra? (Digite 'S' para confirmar ou 'N' para voltar)");
        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("S")) {
            for (Pedidos pedido : carrinho) {
                Historico historico = new Historico(pedido, comprador.getCpf());
                HistoricoDeComprasDAO.adicionarItem(historico);
            }
            System.out.println("Compra realizada com sucesso!");
            carrinho.clear();
        } else {
            System.out.println("Compra cancelada.");
            verCarrinho(comprador);
        }
    }



    private static void opcoesUsuario(Comprador comprador) throws ProdutoNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Opções de Usuário ===");
            System.out.println("1 - Ver histórico de compras");
            System.out.println("2 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println();
                    verHistoricoCompras(comprador);
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal...");
                    exibirMenu(comprador);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 2);
    }

    private static void verHistoricoCompras(Comprador comprador) throws ProdutoNotFoundException {
        System.out.println(comprador.getHistoricoCompras());
        System.out.println();
        exibirMenu(comprador);
    }
}
