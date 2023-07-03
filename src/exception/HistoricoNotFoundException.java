package exception;

public class HistoricoNotFoundException extends Exception {
    public HistoricoNotFoundException(String cpf){
        super("Histórico:" +cpf+ "Histórico não encontrado",  new Throwable("Histórico incorreto ou não encotrado"));
    }
}
    

