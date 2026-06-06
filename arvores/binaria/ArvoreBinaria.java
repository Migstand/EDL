import java.util.Iterator;
import java.util.ArrayList;

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
            // Iterator<No> filhos = children(ra);
            // while (filhos.hasNext()){
            //     No it = filhos.next();
            //     h = Math.max(h, height(ra));
            // }
            if (hasLeft(ra)){
                h = Math.max(h, height(leftChild(ra)));
            }
            if (hasRight(ra)){
                h = Math.max(h, height(rightChild(ra)));
            }
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
        ArrayList<No> dois = new ArrayList<>(2);
        if (hasLeft(no)){
            dois.add(no.getEsq());
        }
        if (hasRight(no)){
            dois.add(no.getDir());
        }
        Iterator<No> filhos = dois.iterator();
        return filhos;
    }

    // METODOS DE CONSULTA \\
    public boolean isInternal(No no){
        return (hasLeft(no) || hasRight(no));
    }

    public boolean isExternal(No no){
        return (!(hasLeft(no)) && !(hasRight(no)));
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

    // MÉTODOS DE BUSCA \\
    public void pre_order(No v, ArrayList<Object> lista){
        if (v == null){
            return;
        }

        lista.add(v.getElemento());

        Iterator<No> meus_fi = children(v);

        while (meus_fi.hasNext()){
            No prox = meus_fi.next();
            pre_order(prox, lista);
        }
    }

    public void pre_orderNo(No v, ArrayList<No> lista){
        if (v == null){
            return;
        }

        lista.add(v);

        Iterator<No> meus_fi = children(v);

        while (meus_fi.hasNext()){
            No prox = meus_fi.next();
            pre_orderNo(prox, lista);
        }
    }

    // METODOS DE ATUALIZAÇÃO \\
    public Object replace(No no, Object o){
        Object replaced = no.getElemento();
        no.setElemento(o);
        return replaced;
    }

    public void addLeft(No no, Object o){
        if (hasLeft(no)){
            ;
        }else{
            No novo = new No(no, o);
            no.setEsq(novo);
            tam++;
        }
    }

    public void addRight(No no, Object o){
        if (hasRight(no)){
            ;
        } else {
            No novo = new No(no, o);
            no.setDir(novo);
            tam++;
        }
    }

    public void removeFilho(No no){
        if (isExternal(no)){
            if ((no.getPai()).getEsq() == no){
                (no.getPai()).setEsq(null);   
            } else {
                (no.getPai()).setDir(null);   
            }
        } else{
            Object swit = inOrderfind(no);

            no.setElemento(swit);
            
        }
        tam--;
    }

    private Object inOrderfind(No no){
        if (hasLeft(no)){
            Object ele = inOrderfind(leftChild(no));
            return ele;
        } if (hasRight(no)){
            Object ele = inOrderfind(rightChild(no));
            return ele;
        }

        Object ele = no.getElemento();
        if ((no.getPai()).getEsq() == no){
                (no.getPai()).setEsq(null);   
            } else {
                (no.getPai()).setDir(null);   
            }
        return ele;
    }
    
}