package exception;

public class CompradorNotFoundException extends Exception {
    public CompradorNotFoundException(String cpf) {
        super("Comprador: "+cpf +" não existe", new Throwable("Comprador incorreta ou não existe"));
    }
    
}
