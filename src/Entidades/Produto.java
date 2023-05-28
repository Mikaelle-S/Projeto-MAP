package Entidades;
import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
    private String nome;
    private String tipo;
    private String marca;
    private String descricao;
    private double valor;
    private int quantidade;

    public Produto(String nome, String tipo, String marca, String descricao, double valor, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", tipo=" + tipo + ", marca=" + marca + ", descricao=" + descricao + ", valor="
                + valor + ", quantidade=" + quantidade + "]";
    }
    @Override
    
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Produto other = (Produto) obj;
    return Objects.equals(nome, other.nome) &&
            Objects.equals(tipo, other.tipo) &&
            Objects.equals(marca, other.marca) &&
            Objects.equals(descricao, other.descricao) &&
            valor == other.valor &&
            quantidade == other.quantidade;
}
}
