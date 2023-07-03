package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Vendas implements Serializable {
    private String hora;
    private String data;
    private Pedidos pedido;
    
    public Vendas() {
    }

    
    public Vendas(Pedidos pedido) {
        this.pedido = pedido;
        this.data = LocalDate.now().toString();
        this.hora = LocalTime.now().toString();
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }


    @Override
    public String toString() {
        return  "Data: " + data + " Hora: " + hora + "\nVendas -> " + pedido;
    }
   
}

