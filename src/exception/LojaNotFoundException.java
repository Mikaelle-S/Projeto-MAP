package exception;

public class LojaNotFoundException extends Exception {
    public LojaNotFoundException(String cpfCnpj) {
        super("Loja: "+cpfCnpj +" não existe", new Throwable("Loja incorreta ou não existe"));
    }
}
