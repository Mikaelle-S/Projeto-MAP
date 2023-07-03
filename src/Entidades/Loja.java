package Entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Loja implements Serializable{
    private String nome;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String endereco;
    private List<Avaliacao> avaliacoes;

    private double qntAvaliacao;
    private double nota;

    public Loja(String nome, String email, String senha, String cpfCnpj, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.avaliacoes = new ArrayList<>();
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
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
        return "Loja [nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpfCnpj=" + cpfCnpj + ", endereco="
                + endereco + "]";
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }

    Loja other = (Loja) obj;

    return Objects.equals(nome, other.nome) &&
           Objects.equals(email, other.email) &&
           Objects.equals(senha, other.senha) &&
           Objects.equals(cpfCnpj, other.cpfCnpj) &&
           Objects.equals(endereco, other.endereco);
    }
}

