public class ArvoreBinaria implements InterfaceBinaria{
    private No raiz;
    private int tam;


    public ArvoreBinaria(Object ra){
        raiz = new No(null, ra);
        tam = 1;
    }

    // METODOS GENERICOS \\
    public int size(){
        return tam;
    }

    public boolean isEmpty(){
        return tam == 0;
    }

    public int height(No ra){
        if (isExternal(ra)){
            return 0;
        } else {
            int h = 0;

            // if (hasLeft(ra)){
            //     h = Math.max(h, height(leftChild(ra)));
            // }
            // if (hasRight(ra)){
            //     h = Math.max(h, height(rightChildChild(ra)));
            // }
            return ++h;
        }
    }

    public Iterator<Object> elements(){
        ArrayList<Object> elementos = new ArrayList<Object>();
        pre_order(raiz,elementos);
        
        Iterator<Object> ite = elementos.iterator();
        return ite;
    }

    public Iterator<No> nos(){
        ArrayList<No> elementos = new ArrayList<No>();
        pre_orderNo(raiz, elementos);

        Iterator<No> ite = elementos.iterator();
        return ite;
    }


    // ADITIONAL METHODS \\
    public No leftChild(No no){
        return no.getEsq();
    }

    public No rightChild(No no){
        return no.getDir();
    }

    public boolean hasLeft(No no){
        return no.getEsq() != null;
    }

    public boolean hasRight(No no){
        return no.getDir() != null;
    }


    // MÉTODOS DE ACESSO \\
    public No root(){
        return raiz;
    }

    public No parent(No no){
        return no.getPai();
    }

    public Iterator<No> children(No no){
        Iterator<No> filhos = (no.getFilhos()).iterator();
        return filhos;
    }

    // METODOS DE CONSULTA \\
    public boolean isInternal(No no){
        ArrayList<No> filhos = no.getFilhos();
        int size = filhos.size();
        return size != 0;
    }

    public boolean isExternal(No no){
        ArrayList<No> filhos = no.getFilhos();
        int size = filhos.size();
        return size == 0;
    }

    public boolean isRoot(No no){
        return no == raiz;
    }

    public int depth(No no){
        if (isRoot(no)){
            return 0;
        } else{
            return 1 + depth(parent(no));
        }

    }
}