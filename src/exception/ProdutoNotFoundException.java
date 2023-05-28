package exception;

public class ProdutoNotFoundException extends Exception {
    public ProdutoNotFoundException(String nome) {
        super("Produto: "+nome +" não existe", new Throwable("Produto incorreto ou não existe"));
    }
    
}
