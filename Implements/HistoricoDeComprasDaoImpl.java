package DAO.Implements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.HistoricoDeComprasDAO;
import Entidades.Comprador;
import Entidades.Vendas;

public class HistoricoDeComprasDaoImpl implements HistoricoDeComprasDAO.HistoricoDeComprasDao{
    private Map<Comprador, List<Vendas>> historicoCompras;

    public HistoricoDeComprasDaoImpl() {
        historicoCompras = new HashMap<>();
    }

    @Override
    public void adicionar(Comprador comprador, Vendas venda) {
        List<Vendas> historico = historicoCompras.getOrDefault(comprador, new ArrayList<>());
        historico.add(venda);
        historicoCompras.put(comprador, historico);
    }

    @Override
    public List<Vendas> verHistorico(Comprador comprador) {
        return historicoCompras.getOrDefault(comprador, new ArrayList<>());
    }

    @Override
    public void remover(Comprador comprador, Vendas venda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }
}
