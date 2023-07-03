package Entidades;
import DAO.HistoricoDeComprasDAO;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Comprador implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nome;
    private String email;
    private String senha;
    private String Cpf;
    private String endereco;
    private List<Pedidos> CarrinhoDeCompras;
    private int qntAvaliacao;
    private double nota;

    public Comprador() {
		this("", "", "", "", "");
	}
    
    public void adicionarPedidoAoCarrinho(Pedidos pedidos) {
        CarrinhoDeCompras.add(pedidos);
    }

    public void removerPedidoDoCarrinho(Pedidos pedidos) {
        CarrinhoDeCompras.remove(pedidos);
    }

    public Comprador(String nome, String email, String senha, String Cpf, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.Cpf = Cpf;
        this.endereco = endereco;
        this.CarrinhoDeCompras = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Pedidos> getCarrinhoDeCompras() {
		return CarrinhoDeCompras;
	}

	public void setCarrinhoDeCompras(List<Pedidos> CarrinhoDeCompras) {
		this.CarrinhoDeCompras = CarrinhoDeCompras;
	}

    public List<Historico> getHistoricoCompras() {
        return HistoricoDeComprasDAO.exibirHistoricoComprador(this.Cpf);
    }

    public double getNota() {
        return this.nota / this.qntAvaliacao;
    }

    public void setNota(double nota) {
        qntAvaliacao++;
        this.nota += nota;
    }

    @Override
    public String toString() {
        return "Comprador [nome=" + nome + ", email=" + email + ", senha=" + senha + ", Cpf=" + Cpf + ", endereco="
                + endereco + ", CarrinhoDeCompras=" + CarrinhoDeCompras + "]";
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CarrinhoDeCompras == null) ? 0 : CarrinhoDeCompras.hashCode());
		result = prime * result + ((Cpf == null) ? 0 : Cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

    @Override
    public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null || getClass() != o.getClass()) {
        return false;
    }

    Comprador comprador = (Comprador) o;
    return Objects.equals(nome, comprador.nome) &&
           Objects.equals(email, comprador.email) &&
           Objects.equals(senha, comprador.senha) &&
           Objects.equals(Cpf, comprador.Cpf) &&
           Objects.equals(endereco, comprador.endereco)&&
           Objects.equals(CarrinhoDeCompras, comprador.CarrinhoDeCompras);
    }
}
