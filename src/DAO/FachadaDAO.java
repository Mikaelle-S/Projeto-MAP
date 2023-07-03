package DAO;

import Entidades.*;
import exception.*;

import java.util.List;
import java.util.Scanner;

public class FachadaDAO{

    public static void run() {
/*
        try {
            Produto produto1 = new Produto("Camisa Polo", Itens.VESTUARIO, "Marca 1", "Camisa polo de algodão", 99.99,
                    10, loja);
            Produto produto2 = new Produto("Smartphone", Itens.ELETRÔNICO, "Marca 2",
                    "Smartphone com câmera de alta resolução", 49.99, 5, loja);
            Produto produto3 = new Produto("Sapato Social", Itens.VESTUARIO, "Marca 3", "Sapato social de couro", 89.99,
                    8, loja);
            Produto produto4 = new Produto("Televisão", Itens.ELETRÔNICO, "Marca 4",
                    "Televisão de 55 polegadas com resolução 4K", 999.99, 3, loja);
            Produto produto6 = new Produto("Notebook", Itens.ELETRÔNICO, "Marca 6",
                    "Notebook com processador i7 e 16GB de RAM", 1499.99, 2, loja);
            Produto produto7 = new Produto("Calça Jeans", Itens.VESTUARIO, "Marca 7", "Calça jeans masculina", 79.99,
                    15, loja);
            Produto produto8 = new Produto("Fone de Ouvido", Itens.ELETRÔNICO, "Marca 8",
                    "Fone de ouvido sem fio com cancelamento de ruído", 299.99, 5, loja);
            Produto produto9 = new Produto("Geladeira", Itens.ELETRÔNICO, "Marca 9",
                    "Geladeira frost-free com capacidade de 400 litros", 1999.99, 4, loja);
            Produto produto10 = new Produto("Tênis Esportivo", Itens.VESTUARIO, "Marca 10",
                    "Tênis esportivo com amortecimento de impacto", 129.99, 6, loja);

            ProdutoDAO.cadastrarProduto(produto1);
            ProdutoDAO.cadastrarProduto(produto2);
            ProdutoDAO.cadastrarProduto(produto3);
            ProdutoDAO.cadastrarProduto(produto4);
            ProdutoDAO.cadastrarProduto(produto6);
            ProdutoDAO.cadastrarProduto(produto7);
            ProdutoDAO.cadastrarProduto(produto8);
            ProdutoDAO.cadastrarProduto(produto9);
            ProdutoDAO.cadastrarProduto(produto10);
             } catch (LojaJaExistenteException | LojaNotFoundException e) {
            e.printStackTrace();
        }
*/
        try {
            /*Loja loja = new Loja("Americanas", "americanas@email.com", "senha123", "Americanas", "rua tal, 001");
            LojaDAO.cadastrar(loja);
            Produto produto1 = new Produto("Camisa Polo", Itens.VESTUARIO, "Marca 1", "Camisa polo de algodão", 99.99,
                    10, loja);
            Produto produto2 = new Produto("Smartphone", Itens.ELETRÔNICO, "Marca 2",
                    "Smartphone com câmera de alta resolução", 49.99, 5, loja);
            Produto produto3 = new Produto("Sapato Social", Itens.VESTUARIO, "Marca 3", "Sapato social de couro", 89.99,
                    8, loja);
            Produto produto4 = new Produto("Televisão", Itens.ELETRÔNICO, "Marca 4",
                    "Televisão de 55 polegadas com resolução 4K", 999.99, 3, loja);
            Produto produto6 = new Produto("Notebook", Itens.ELETRÔNICO, "Marca 6",
                    "Notebook com processador i7 e 16GB de RAM", 1499.99, 2, loja);
            Produto produto7 = new Produto("Calça Jeans", Itens.VESTUARIO, "Marca 7", "Calça jeans masculina", 79.99,
                    15, loja);
            Produto produto8 = new Produto("Fone de Ouvido", Itens.ELETRÔNICO, "Marca 8",
                    "Fone de ouvido sem fio com cancelamento de ruído", 299.99, 5, loja);
            Produto produto9 = new Produto("Geladeira", Itens.ELETRÔNICO, "Marca 9",
                    "Geladeira frost-free com capacidade de 400 litros", 1999.99, 4, loja);
            Produto produto10 = new Produto("Tênis Esportivo", Itens.VESTUARIO, "Marca 10",
                    "Tênis esportivo com amortecimento de impacto", 129.99, 6, loja);

            ProdutoDAO.cadastrarProduto(produto1);
            ProdutoDAO.cadastrarProduto(produto2);
            ProdutoDAO.cadastrarProduto(produto3);
            ProdutoDAO.cadastrarProduto(produto4);
            ProdutoDAO.cadastrarProduto(produto6);
            ProdutoDAO.cadastrarProduto(produto7);
            ProdutoDAO.cadastrarProduto(produto8);
            ProdutoDAO.cadastrarProduto(produto9);
            ProdutoDAO.cadastrarProduto(produto10);

             */
            menuPrincipal();
        } catch (LojaNotFoundException e) {
            System.err.print("Loja inexistente");
        } //catch (LojaJaExistenteException e) {
          //  throw new RuntimeException(e);
        // }
    }

    private static void menuPrincipal() throws LojaNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("=== Menu Principal ===");
            System.out.println("1 - Cadastrar loja");
            System.out.println("2 - Entrar como loja");
            System.out.println("3 - Cadastrar Comprador");
            System.out.println("4 - Entrar como Comprador");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    cadastrarLoja();
                    break;
                case 2:
                    loginLoja();
                    break;
                case 3:
                    cadastrarComprador();
                    break;
                case 4:
                    loginComprador();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarLoja() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Nome da Loja: ");
            String nome = scanner.nextLine();
            System.out.println("Email da Loja: ");
            String email = scanner.nextLine();
            System.out.println("Senha da Loja: ");
            String senha = scanner.nextLine();
            System.out.println("CNPJ ou CPF da Loja: ");
            String cnpj = scanner.nextLine();
            System.out.println("Endereco da Loja: ");
            String endereco = scanner.nextLine();

            Loja loja = new Loja(nome, email, senha, cnpj, endereco);
            LojaDAO.cadastrar(loja);
            System.out.println("Loja cadastrada com Sucesso.");
            menuPrincipal();
        } catch (LojaJaExistenteException e) {
            System.err.println("Já existe uma loja com esses dados cadastrados.");
        } catch (LojaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loginLoja() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("CNPJ da loja: ");
            String cnpj = scanner.nextLine();
            Loja loja = LojaDAO.buscar(cnpj);
            System.out.println("Senha da loja: ");
            String senha = scanner.nextLine();
            menuPrincipalLoja(loja);
        } catch (LojaNotFoundException e) {
            System.out.println("CNPJ invalido");
        } catch (ProdutoNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cadastrarComprador() throws LojaNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Nome do Comprador: ");
        String nome = scanner.nextLine();
        System.out.println("Email do Comprador: ");
        String email = scanner.nextLine();
        System.out.println("Senha do Comprador: ");
        String senha = scanner.nextLine();
        System.out.println("CPF do Comprador: ");
        String cpf = scanner.nextLine();
        System.out.println("Endereço do Comprador: ");
        String endereco = scanner.nextLine();

        Comprador comprador = new Comprador(nome, email, senha, cpf, endereco);
        CompradorDAO.cadastrarComprador(comprador);
        System.out.println("Comprador cadastrado com sucesso com Sucesso.");
        menuPrincipal();
    }

    private static void loginComprador() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();
            Comprador comprador = CompradorDAO.buscarComprador(cpf);
            System.out.println("Senha: ");
            String senha = scanner.nextLine();
            menuCompradores(comprador);
        } catch (CompradorNotFoundException e) {
            System.err.println("CPF invalido");
        } catch (ProdutoNotFoundException e) {
            System.err.println("Produto invalido.");
        } catch (LojaNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void menuPrincipalLoja(Loja loja) throws LojaNotFoundException, ProdutoNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("=== Menu Loja ===");
            System.out.println("1 - Editar Loja");
            System.out.println("2 - Listar Lojas");
            System.out.println("3 - Remover Loja");
            System.out.println("4 - Cadastrar Produto");
            System.out.println("5 - Listar Produtos");
            System.out.println("6 - Editar Produtos");
            System.out.println("7 - Remover Produto");
            System.out.println("8 - Avaliar Comprador");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    editarLoja(loja);
                    break;
                case 2:
                    System.out.println("=== Lojas Cadastradas ===");
                    for (Loja lojas: LojaDAO.listarLoja()) {
                        System.out.println(lojas);
                    }
                    break;
                case 3:
                    try {
                        System.out.println();
                        System.out.println("Digite o CPF ou CNPJ que deseja apagar: ");
                        String cnpj = scanner.next();
                        LojaDAO.remover(LojaDAO.buscar(cnpj));
                        System.out.println("Loja deletada com sucesso.");
                    } catch (LojaNotFoundException e) {
                        System.err.println("Essa loja não existe");
                        break;
                    }
                    break;
                case 4:
                    cadastrarProdutos(loja);
                    break;
                case 5:{
                    System.out.println("=== Produtos ===");
                    for (Produto produto : ProdutoDAO.listarPorLoja(loja)) {
                        System.out.println(produto);
                    }
                    break;
                }
                case 6: {
                    editarProdutos();
                    break;
                } case 7:
                    try {
                        System.out.println();
                        System.out.println("=== Produtos Cadastrados ===");
                        exibirListagemProdutos();
                        System.out.println();
                        System.out.println("Digite o nome do produto que deseja remover: ");
                        String nome = scanner.nextLine();
                        ProdutoDAO.removerProduto(ProdutoDAO.buscarProduto(nome));
                        System.out.println("Sucesso.");
                    } catch (ProdutoNotFoundException e) {
                        System.err.println("Produto invalido.");
                        break;
                } case 8: {
                    try {
                        System.out.println("=== Compradores ===");
                        for (Comprador comprador : CompradorDAO.listarCompradores()) {
                            System.out.println(comprador);
                        }
                        System.out.println("Digite o CPF do comprador que deseja avaliar: ");
                        String cpf = scanner.next();
                        Comprador comprador = CompradorDAO.buscarComprador(cpf);
                        System.out.println("Qual nota de 0 a 5 vc daria ao " + comprador.getNome() + ": ");
                        double nota = scanner.nextDouble();
                        while (nota > 5 || nota < 0) {
                            System.out.println("Nota de 0 a 5: ");
                            nota = scanner.nextDouble();
                        }
                        comprador.setNota(nota);
                        CompradorDAO.atualizarComprador(comprador);
                        break;
                    } catch (CompradorNotFoundException e){
                        System.err.println("CPF invalido");
                        break;
                    }
                } case 0:
                    System.out.println("Saindo...");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void editarLoja(Loja loja) throws LojaNotFoundException, ProdutoNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcaoEdita;
        System.out.println("=== Oque deseja editar ===");
        System.out.println("1 - Nome");
        System.out.println("2 - Email");
        System.out.println("3 - Senha");
        System.out.println("4 - Endereco");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        opcaoEdita = scanner.nextInt();
        System.out.println();

        switch (opcaoEdita) {
            case 1: {
                System.out.println("Novo nome: ");
                String nome = scanner.next();
                Loja lojaEditar = new Loja(nome, loja.getEmail(), loja.getSenha(), loja.getCpfCnpj(), loja.getEndereco());
                LojaDAO.atualizar(lojaEditar);
                System.out.println("Sucesso.");
                break;
            } case 2: {
                System.out.println("Novo email: ");
                String email = scanner.next();
                Loja lojaEditar = new Loja(loja.getNome(), email, loja.getSenha(), loja.getCpfCnpj(), loja.getEndereco());
                LojaDAO.atualizar(lojaEditar);
                System.out.println("Sucesso.");
                break;
            } case 3: {
                System.out.println("Nova senha: ");
                String senha = scanner.next();
                Loja lojaEditar = new Loja(loja.getNome(), loja.getEmail(), senha, loja.getCpfCnpj(), loja.getEndereco());
                LojaDAO.atualizar(lojaEditar);
                System.out.println("Sucesso.");
                break;
            } case 4: {
                System.out.println("Novo Endereço: ");
                String endereco = scanner.next();
                Loja lojaEditar = new Loja(loja.getNome(), loja.getEmail(), loja.getSenha(), loja.getCpfCnpj(), endereco);
                LojaDAO.atualizar(lojaEditar);
                System.out.println("Sucesso.");
                break;
            } case 0:
                System.out.println("Saindo...");
                menuPrincipalLoja(loja);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    public static void cadastrarProdutos(Loja loja) throws LojaNotFoundException, ProdutoNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Tipo do produto: ");
        System.out.println("1 - Comida");
        System.out.println("2 - Eletronico");
        System.out.println("3 - Vestuario");
        int opc = scanner.nextInt();
        System.out.println("Marca do Produto: ");
        String marca = scanner.next();
        System.out.println("Descrição do produto: ");
        String descricao = scanner.next();
        System.out.println("Valor do Produto: ");
        double valor = scanner.nextDouble();
        System.out.println("Quantidade do Produto: ");
        int quantidade = scanner.nextInt();
        switch (opc) {
            case 1: {
                Produto produto = new Produto(nome, Itens.COMIDA, marca, descricao, valor, quantidade, loja);
                ProdutoDAO.cadastrarProduto(produto);
                System.out.println("Produto cadastrado com sucesso.");
                break;
            } case 2: {
                Produto produto = new Produto(nome, Itens.ELETRÔNICO, marca, descricao, valor, quantidade, loja);
                ProdutoDAO.cadastrarProduto(produto);
                System.out.println("Produto cadastrado com sucesso.");
                break;
            } case 3: {
                Produto produto = new Produto(nome, Itens.VESTUARIO, marca, descricao, valor, quantidade, loja);
                ProdutoDAO.cadastrarProduto(produto);
                System.out.println("Produto cadastrado com sucesso.");
                break;
            } default:
                System.out.println("Opção inválida! Tente novamente.");
        }
        menuPrincipalLoja(loja);
    }

    private static void editarProdutos() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println();
            System.out.println("=== Produtos Cadastrados ===");
            exibirListagemProdutos();
            System.out.println();
            System.out.println("Digite o nome do produto que deseja editar: ");
            String nome = scanner.nextLine();
            Produto produto = ProdutoDAO.buscarProduto(nome);
            int opcaoEdita;
            System.out.println("=== Oque deseja editar ===");
            System.out.println("1 - Nome");
            System.out.println("2 - Tipo");
            System.out.println("3 - Marca");
            System.out.println("4 - Descricao");
            System.out.println("5 - Valor");
            System.out.println("6 - Quantidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoEdita = scanner.nextInt();
            System.out.println();

            switch (opcaoEdita) {
                case 1: {
                    System.out.println("Novo nome: ");
                    String novoNome = scanner.next();
                    produto.setNome(novoNome);
                    ProdutoDAO.atualizarProduto(produto);
                    System.out.println("Sucesso.");
                    break;
                } case 2: {
                    System.out.println("Novo Tipo do produto: ");
                    System.out.println("1 - Comida");
                    System.out.println("2 - Eletronico");
                    System.out.println("3 - Vestuario");
                    int opc = scanner.nextInt();
                    switch (opc) {
                        case 1:
                            produto.setTipo(Itens.COMIDA);
                            break;
                        case 2:
                            produto.setTipo(Itens.ELETRÔNICO);
                            break;
                        case 3:
                            produto.setTipo(Itens.VESTUARIO);
                            break;
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                    }
                    ProdutoDAO.atualizarProduto(produto);
                    System.out.println("Sucesso.");
                    break;
                } case 3: {
                    System.out.println("Nova Marca: ");
                    String marca = scanner.next();
                    produto.setMarca(marca);
                    ProdutoDAO.atualizarProduto(produto);
                    System.out.println("Sucesso.");
                    break;
                } case 4: {
                    System.out.println("Nova Descrição: ");
                    String descricao = scanner.next();
                    produto.setDescricao(descricao);
                    ProdutoDAO.atualizarProduto(produto);
                    System.out.println("Sucesso.");
                    break;
                } case 5: {
                    System.out.println("Novo Valor: ");
                    double valor = scanner.nextDouble();
                    produto.setValor(valor);
                    ProdutoDAO.atualizarProduto(produto);
                    System.out.println("Sucesso.");
                    break;
                } case 6: {
                    System.out.println("Nova Quantidade: ");
                    int quantidade = scanner.nextInt();
                    produto.setQuantidade(quantidade);
                    ProdutoDAO.atualizarProduto(produto);
                    System.out.println("Sucesso.");
                    break;
                } case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } catch (ProdutoNotFoundException e) {
            System.err.println("Produto invalido");
        }
    }
    private static void menuCompradores(Comprador comp) throws ProdutoNotFoundException, LojaNotFoundException, CompradorNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("=== Menu Compradores ===");
            System.out.println("1 - Editar");
            System.out.println("2 - Informações Pessoais");
            System.out.println("3 - Avaliações das lojas");
            System.out.println("4 - Fazer Compras");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    editarComprador(comp);
                    break;
                case 2:
                    System.out.println("=== Informações Pessoais ===");
                    System.out.printf("Nome: " + comp.getNome() + "\n");
                    System.out.printf("Email: " + comp.getEmail() + "\n");
                    System.out.printf("CPF: " + comp.getCpf() + "\n");
                    System.out.printf("Endereço: " + comp.getEndereco() + "\n");
                    break;
                case 3:
                    System.out.println("=== Lojas Avaliadas ===");
                    for (Loja loja: LojaDAO.listarLoja()) {
                        System.out.printf("Loja: " + loja.getNome() + " Nota: " + loja.getNota() + "\n");
                        for (Avaliacao avaliacao : loja.getAvaliacoes()) {
                            System.out.println(" Avaliação: " + avaliacao.getComentario() + " Nota: " + avaliacao.getNota());
                        }
                    }
                    break;
                case 4:
                    System.out.println("=== Lojas Disponiveis ===");
                    for (Loja loja : LojaDAO.listarLoja()) {
                        System.out.println(loja);
                    }
                    System.out.println("Qual loja deseja comprar, digite o nome: ");
                    String nome = scanner.next();
                    menuLoja(comp, LojaDAO.buscarNome(nome));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void editarComprador(Comprador comp) throws ProdutoNotFoundException, LojaNotFoundException, CompradorNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Oque deseja editar ===");
        System.out.println("1 - Nome");
        System.out.println("2 - Email");
        System.out.println("3 - Senha");
        System.out.println("4 - CPF");
        System.out.println("5 - Endereco");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcaoEdita = scanner.nextInt();

        switch (opcaoEdita) {
            case 1:
                System.out.println("Novo nome: ");
                String novoNome = scanner.next();
                comp.setNome(novoNome);
                CompradorDAO.atualizarComprador(comp);
                System.out.println("Sucesso.");
                break;
            case 2:
                System.out.println("Novo Email: ");
                String novoEmail = scanner.next();
                comp.setEmail(novoEmail);
                CompradorDAO.atualizarComprador(comp);
                System.out.println("Sucesso.");
                break;
            case 3:
                System.out.println("Senha atual: ");
                String senhaAtual = scanner.next();
                while (comp.getSenha() != senhaAtual) {
                    System.out.println("Senha incorreta, tente novamento: ");
                    senhaAtual = scanner.nextLine();
                }
                System.out.println("Nova senha: ");
                String senha = scanner.next();
                comp.setSenha(senha);
                CompradorDAO.atualizarComprador(comp);
                System.out.println("Sucesso.");
                break;
            case 4:
                System.out.println("Novo CPF: ");
                String cpf = scanner.next();
                comp.setCpf(cpf);
                CompradorDAO.atualizarComprador(comp);
                System.out.println("Sucesso.");
                break;
            case 5:
                System.out.println("Novo Endereco: ");
                String endereco = scanner.next();
                comp.setEndereco(endereco);
                CompradorDAO.atualizarComprador(comp);
                System.out.println("Sucesso.");
                break;
            case 0:
                System.out.println("Saindo...");
                menuCompradores(comp);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
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

    private static void menuLoja(Comprador comprador, Loja loja) throws
            ProdutoNotFoundException, LojaNotFoundException, CompradorNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("=== " + loja.getNome() + " ===");
            System.out.println("=== Produtos ===");
            for (Produto produto : ProdutoDAO.listarPorLoja(loja)) {
                System.out.println(produto);
            }
            System.out.println();
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
                    verCarrinho(comprador, loja);
                    break;
                case 3:
                    opcoesUsuario(comprador, loja);
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    menuCompradores(comprador);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 0);
        menuCompradores(comprador);
    }

    private static void adicionarItemCarrinho(Comprador comprador) throws ProdutoNotFoundException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do produto: ");
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
            System.err.println("Ocorreu um erro inesperado " + e);
        }
    }

    private static void verCarrinho(Comprador comprador, Loja loja)
            throws ProdutoNotFoundException, LojaNotFoundException, CompradorNotFoundException {
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
                    comprarCarrinho(comprador, loja);
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal...");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 2);

    }

    private static void comprarCarrinho(Comprador comprador, Loja loja)
            throws ProdutoNotFoundException, LojaNotFoundException, CompradorNotFoundException {
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

            // Avaliar Compra
            System.out.println("Deseja avaliar a compra? (Digite 'S' para sim ou 'N' para não)");
            String opcaoAvaliar = scanner.nextLine();
            if (opcaoAvaliar.equalsIgnoreCase("S")) {
                System.out.println("Que nota você dá para a loja de 0 a 5?");
                int nota = scanner.nextInt();
                System.out.println("Faça um comentário sobre a compra: ");
                scanner.nextLine();
                String comentario = scanner.nextLine();
                Avaliacao av = new Avaliacao(nota, comentario);
                List<Avaliacao> avAtualizadas = loja.getAvaliacoes();
                avAtualizadas.add(av);
                loja.setAvaliacoes(avAtualizadas);
                LojaDAO.atualizar(loja);

                System.out.println("Avaliação feita com sucesso!");
            }

        } else {
            System.out.println("Compra cancelada.");
            verCarrinho(comprador, loja);
        }
    }

    private static void opcoesUsuario(Comprador comprador, Loja loja) throws ProdutoNotFoundException, LojaNotFoundException, CompradorNotFoundException {
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
                    menuLoja(comprador, loja);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 2);
    }

    private static void verHistoricoCompras(Comprador comprador)
            throws ProdutoNotFoundException, LojaNotFoundException {
        System.out.println(comprador.getHistoricoCompras());
        System.out.println();
        menuPrincipal();
    }
}