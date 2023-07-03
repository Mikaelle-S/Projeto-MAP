package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Avaliacao implements Serializable {
    private String hora;
    private String data;
    private int nota;
    private String comentario;

    public Avaliacao(int nota, String comentario) {
        this.data = LocalDate.now().toString();
        this.hora = LocalTime.now().toString();
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String toString(String nomeUsuario) {
        return "Usuário: " + nomeUsuario + "\n" +
                "Nota: " + nota + "\n" +
                "Comentário: " + comentario + "\n";
    }
}
