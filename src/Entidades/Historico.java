package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Historico implements Serializable {
    private Pedidos pedidos;
    private String cpf;

    public Historico(Pedidos pedidos, String cpf) {
        this.pedidos = pedidos;
        this.cpf = cpf;
    }

    public Historico() {
    }

    public Pedidos getCompra() {
        return pedidos;
    }

    public void setCompra(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Historico historico = (Historico) o;
        return Objects.equals(pedidos, historico.pedidos) && Objects.equals(cpf, historico.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidos, cpf);
    }

    @Override
    public String toString() {
        return "Historico [" +
                "compra =" + pedidos +
                ", cpf ='" + cpf + ']';
    }
}
