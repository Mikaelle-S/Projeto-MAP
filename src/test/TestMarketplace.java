package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import DAO.CompradorDAO;
import DAO.LojaDAO;
import DAO.ProdutoDAO;
import Entidades.Comprador;
import Entidades.Loja;
import Entidades.Produto;
import exception.CompradorNotFoundException;
import exception.LojaJaExistenteException;
import exception.LojaNotFoundException;
import exception.ProdutoNotFoundException;

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

        Produto produto = new Produto("Produto 11", "Eletrônicos", "Marca 11", "Descrição 11", 11.11, 100);
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
}
