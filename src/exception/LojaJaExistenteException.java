package exception;

public class LojaJaExistenteException extends Exception  {
    public LojaJaExistenteException(String cpfCnpj) {
        super("Loja com CPF/CNPJ " + cpfCnpj + " já está cadastrada.");
    }
}
