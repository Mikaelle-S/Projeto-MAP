package DAO;


import java.util.List;

import Entidades.Comprador;
import Entidades.Produto;
import exception.LojaNotFoundException;

public interface CarrinhoDeComprasDao {
    
    void adicionar(Comprador comprador, Produto obj);
    void remover(Comprador comprador, Produto obj);
    List<Produto> listarProdutos(Comprador comprador);
    void comprar(Comprador comprador, Produto obj, int quantidade) throws LojaNotFoundException;
}
