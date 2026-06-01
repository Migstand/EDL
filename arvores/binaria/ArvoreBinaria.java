public class ArvoreBinaria implements InterfaceBinaria{
    private No raiz;
    private int tam;


    public ArvoreBinaria(Object ra){
        raiz = new No(null, ra);
        tam = 1;
    }

    
}