package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;


import DAO.CompradorDAO;
import DAO.LojaDAO;
import DAO.ProdutoDAO;
import exception.CompradorNotFoundException;
import exception.LojaJaExistenteException;
import exception.LojaNotFoundException;
import exception.ProdutoNotFoundException;

import java.util.List;

import static org.junit.Assert.*;


class TestMarketplace {

	@Test
    public void testCadastrarLoja() throws LojaNotFoundException, LojaJaExistenteException {
        Loja loja = new Loja("Loja 10", "loja10@example.com", "111senha", "111222333", "Endereço 10");
        LojaDAO.cadastrar(loja);

        Loja lojaEncontrada = LojaDAO.buscar("111222333");
        Assertions.assertEquals(loja, lojaEncontrada);
    }

    @Test
    public void testCadastrarComprador() throws CompradorNotFoundException {
        Comprador comprador = new Comprador("Comprador 1", "comprador1@example.com", "senha789", "CPF 1", "Endereço 3");
        CompradorDAO.cadastrarComprador(comprador);

        Comprador compradorEncontrado = CompradorDAO.buscarComprador("CPF 1");
        Assertions.assertEquals(comprador, compradorEncontrado);
    }

    @Test
    public void testCadastrarProduto() throws LojaNotFoundException, ProdutoNotFoundException, LojaJaExistenteException {
        Loja loja = new Loja("Loja 11", "loja11@example.com", "senha111", "999888777", "Endereço 11");
        LojaDAO.cadastrar(loja);

        Produto produto = new Produto("Produto 11", Itens.ELETRÔNICO, "Marca 11", "Descrição 11", 11.11, 100);
        ProdutoDAO.cadastrarProduto(produto);

        Produto produtoEncontrado = ProdutoDAO.buscarProduto("Produto 11");
        Assertions.assertEquals(produto, produtoEncontrado);
    }

    @Test
    public void testBuscarLojaInexistente() {
        Assertions.assertThrows(LojaNotFoundException.class, () -> {
            LojaDAO.buscar("333654789");
        });
    }

    @Test
    public void testBuscarCompradorInexistente() {
        Assertions.assertThrows(CompradorNotFoundException.class, () -> {
            CompradorDAO.buscarComprador("CPF 2");
        });
    }

    @Test
    public void testBuscarProdutoInexistente() throws LojaNotFoundException {
        Assertions.assertThrows(ProdutoNotFoundException.class, () -> {
            ProdutoDAO.buscarProduto("Produto 2");
        });
    }

    @Test
    public void testAddCarrinhoDeCompras() throws LojaNotFoundException, LojaJaExistenteException, ProdutoNotFoundException {
        Loja loja = new Loja("Loja 20", "loja20@example.com", "200senha", "200222333", "Endereço 20");
        LojaDAO.cadastrar(loja);

        Comprador comprador = new Comprador("Comprador 5", "comprador5@example.com", "senha789", "CPF 5", "Endereço 5");
        CompradorDAO.cadastrarComprador(comprador);

        Produto produto = new Produto("Produto 11", Itens.ELETRÔNICO, "Marca 11", "Descrição 11", 11.11, 100);
        ProdutoDAO.cadastrarProduto(produto);

        // Adicionar produto ao carrinho do comprador
        //comprador.adicionarProdutoAoCarrinho(produto);


        // Verificar se o produto foi adicionado corretamente ao carrinho
        Assertions.assertEquals(1, comprador.getCarrinhoDeCompras().size());
        Assertions.assertEquals(produto, comprador.getCarrinhoDeCompras().get(0));
    }

    @Test
    public void testRemoverProdutoDoCarrinho() throws LojaNotFoundException, LojaJaExistenteException, ProdutoNotFoundException {
        Loja loja = new Loja("Loja 10", "loja10@example.com", "111senha", "111222333", "Endereço 10");
        LojaDAO.cadastrar(loja);


        Comprador comprador = new Comprador("Comprador 1", "comprador1@example.com", "senha789", "CPF 1", "Endereço 3");
        CompradorDAO.cadastrarComprador(comprador);

        Produto produto1 = new Produto("Produto 9", Itens.ELETRÔNICO, "Marca 9", "Descrição 9", 75.50, 3);
        ProdutoDAO.cadastrarProduto(produto1);

        Produto produto2 = new Produto("Produto 10", Itens.VESTUARIO, "Marca 10", "Descrição 10", 38.90, 5);
        ProdutoDAO.cadastrarProduto(produto2);


        // Remover produto do carrinho de compras
        //comprador.removerProdutoDoCarrinho(produto1);

        // Verificar se o produto foi removido corretamente do carrinho
        Assertions.assertEquals(1, comprador.getCarrinhoDeCompras().size());
        Assertions.assertEquals(produto2, comprador.getCarrinhoDeCompras().get(0));
    }
}

