package Entidades;
import java.io.Serializable;
import java.util.Objects;

public class Comprador implements Serializable{
    private String nome;
    private String email;
    private String senha;
    private String Cpf;
    private String endereco;

    public Comprador(String nome, String email, String senha, String Cpf, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.Cpf = Cpf;
        this.endereco = endereco;
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

    @Override
    public String toString() {
        return "Comprador [nome=" + nome + ", email=" + email + ", senha=" + senha + ", Cpf=" + Cpf + ", endereco="
                + endereco + "]";
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
           Objects.equals(endereco, comprador.endereco);
}
}
