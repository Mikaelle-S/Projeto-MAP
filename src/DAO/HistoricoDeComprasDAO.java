package DAO;

import java.util.List;

import Entidades.Comprador;
import Entidades.Vendas;

public class HistoricoDeComprasDAO  {

    public interface HistoricoDeComprasDao {
        
        void adicionar(Comprador comprador, Vendas venda);
        List<Vendas> verHistorico(Comprador comprador);
        void remover(Comprador comprador, Vendas venda);
    }

}
