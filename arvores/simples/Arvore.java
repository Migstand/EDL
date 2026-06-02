import java.util.Iterator;
import java.util.ArrayList;

public class Arvore implements InterfaceArvore{
    private No raiz;
    private int tam;

    public Arvore(Object o){
        raiz = new No(null, o);
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
            ArrayList<No> filhos = ra.getFilhos();
            for (No ele : filhos){
                h = Math.max(h, height(ele));
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

    // METODOS DE ACESSO \\
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

    // METODOS DE ATUALIZAÇÃO \\
    public Object replace(No no, Object o){
        Object replaced = no.getElemento();
        no.setElemento(o);
        return replaced;
    }

    public void addFilho(No no, Object o){
        No novo_no = new No(no, o);
        no.setFilho(novo_no);
        tam++;
    }
    
    public void removeFilho(No no){
        
        ArrayList<No> fi = no.getFilhos();
        No novo = fi.get(0);
        ArrayList<No> fela = novo.getFilhos();
        for (int i = 1; i < fi.size(); i++){
            fela.add(fi.get(i));
            fi.get(i).setPai(novo);
        }
        
        if (no == root()){
            raiz = novo;
            novo.setPai(null);
        } else {
            ArrayList<No> pailist = (no.getPai()).getFilhos();
            int ind = pailist.indexOf(no);
            novo.setPai((no.getPai()));
            fi = (novo.getPai()).getFilhos();
            
            fi.set(ind, novo);
        }
        tam--;
    }

}