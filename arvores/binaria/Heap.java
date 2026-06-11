import java.util.ArrayList;
import java.util.Iterator;

public class Heap{
    private int num = 0;
    private Noh raiz;
    private int size;
    private Noh ultimo;

    public Heap(Item elemento){
        raiz = new Noh(null, elemento);
        ultimo = raiz;
        size = 1;
    }
    // public Item elemento(int i){
    //     return heap.get(i);
    // }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int height(Noh ra){
        if (isExternal(ra)){
            return 0;
        } else {
            int h = 0;
            // Iterator<Noh> filhos = children(ra);
            // while (filhos.hasNext()){
            //     Noh it = filhos.next();
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

    public Iterator<Item> elements(){
        ArrayList<Item> elementos = new ArrayList<Item>();
        pre_order(raiz,elementos);
        
        Iterator<Item> ite = elementos.iterator();
        return ite;
    }

    public Iterator<Noh> nos(){
        ArrayList<Noh> elementos = new ArrayList<Noh>();
        pre_orderNo(raiz, elementos);

        Iterator<Noh> ite = elementos.iterator();
        return ite;
    }

    // MÉTODOS DE BUSCA \\
    public void pre_order(Noh v, ArrayList<Item> lista){
        if (v == null){
            return;
        }

        lista.add(v.getElemento());

        Iterator<Noh> meus_fi = children(v);

        while (meus_fi.hasNext()){
            Noh prox = meus_fi.next();
            pre_order(prox, lista);
        }
    }

    public void pre_orderNo(Noh v, ArrayList<Noh> lista){
        if (v == null){
            return;
        }

        lista.add(v);

        Iterator<Noh> meus_fi = children(v);

        while (meus_fi.hasNext()){
            Noh prox = meus_fi.next();
            pre_orderNo(prox, lista);
        }
    }

    public void insert(Item ele){
        
        
        Noh encontrado = vai(ultimo);
        Noh novo;

        if (isRoot(encontrado)){
            if (hasRight(encontrado)){
                encontrado =  encontrado.getEsq();
                encontrado = volta(encontrado);
                novo = new Noh(encontrado, ele);
                if (hasLeft(encontrado)){
                    encontrado.setDir(novo);
                    ultimo = novo;
                } else{
                    encontrado.setEsq(novo);
                    ultimo = novo;
                }
            } else {
                if (hasLeft(encontrado)){
                    novo = new Noh(encontrado, ele);
                    encontrado.setDir(novo);
                    ultimo = novo;        
                } else {
                    novo = new Noh(encontrado, ele);
                    encontrado.setEsq(novo);
                    ultimo = novo;
                }
                
            }
        } else{
            Noh paizao = encontrado.getPai();
            if (leftChild(paizao) == encontrado){
            //     novo = new Noh(paizao, ele);
            //     paizao.setDir(novo);
            //     ultimo = novo;
                if (hasRight(paizao)){
                    encontrado =  paizao.getDir();
                    encontrado = volta(encontrado);
                    novo = new Noh(encontrado, ele);
                    if (hasLeft(encontrado)){
                        encontrado.setDir(novo);
                        ultimo = novo;
                    } else{
                        encontrado.setEsq(novo);
                        ultimo = novo;
                    }
                } else {    
                    novo = new Noh(paizao, ele);
                    paizao.setDir(novo);
                    ultimo = novo;
                    
                }
            } else {

                if (hasRight(paizao)){
                encontrado =  paizao.getEsq();
                encontrado = volta(encontrado);
                novo = new Noh(encontrado, ele);
                if (hasLeft(encontrado)){
                    encontrado.setDir(novo);
                    ultimo = novo;
                } else{
                    encontrado.setEsq(novo);
                    ultimo = novo;
                }
            } else {    
                encontrado =  paizao.getEsq();
                encontrado = volta(encontrado);
                novo = new Noh(paizao, ele);
                paizao.setDir(novo);
                ultimo = novo;
                
            }
            }
            
            ultimo = novo;
        }
        
        upheap(ultimo);
    
        size++;

    }

    private Noh volta(Noh no){
        System.out.println(no.getElemento().getChave() + " Chave volta");
        if (isExternal(no)){
            return no;
        }

        if (!hasRight(no)){
            return no;
        }
        else {
            return volta(no.getEsq());
            
        }
    }

    private Noh vai(Noh no){
        System.out.println(no.getElemento().getChave() + " Chave vai");
        if (no == null){
            return no;
        }
        if (isRoot(no)){
            return no;
        }
        
        if(leftChild(no.getPai()) == no){
            return no;
        } else{
            return vai(no.getPai());
        }
    }


    // ADITIONAL METHODS \\
    public Noh leftChild(Noh no){
        return no.getEsq();
    }

    public Noh rightChild(Noh no){
        return no.getDir();
    }

    public boolean hasLeft(Noh no){
        return no.getEsq() != null;
    }

    public boolean hasRight(Noh no){
        return no.getDir() != null;
    }


    // MÉTODOS DE ACESSO \\
    public Noh root(){
        return raiz;
    }

    public Noh parent(Noh no){
        return no.getPai();
    }

    public Iterator<Noh> children(Noh no){
        ArrayList<Noh> dois = new ArrayList<>(2);
        if (hasLeft(no)){
            dois.add(no.getEsq());
        }
        if (hasRight(no)){
            dois.add(no.getDir());
        }
        Iterator<Noh> filhos = dois.iterator();
        return filhos;
    }

    // METODOS DE CONSULTA \\
    public boolean isInternal(Noh no){
        return (hasLeft(no) || hasRight(no));
    }

    public boolean isExternal(Noh no){
        return (!(hasLeft(no)) && !(hasRight(no)));
    }

    public boolean isRoot(Noh no){
        return no == raiz;
    }

    public int depth(Noh no){
        if (isRoot(no)){
            return 0;
        } else{
            return 1 + depth(parent(no));
        }

    }

    private void upheap(Noh no){
        while (null != no.getPai() && (no.getElemento()).getChave() < ((no.getPai()).getElemento()).getChave()){
            
            Item sub = no.getElemento();
            no.setElemento((no.getPai()).getElemento());
            (no.getPai()).setElemento(sub);

            no = no.getPai();
        }

    }

    public Noh min(){
        return raiz;
    }

    public int removeMin(){
        Item removed = min().getElemento();
        
        raiz.setElemento(ultimo.getElemento());
        if (leftChild(ultimo.getPai())== ultimo){
            ultimo.getPai().setEsq(null);    
        } else{
            ultimo.getPai().setDir(null);
        }
        Noh encontrado = vaiesp(ultimo);

        if (isRoot(encontrado)){
            if (hasLeft(encontrado)){
                encontrado =  encontrado.getEsq();
                ultimo = voltaesp(encontrado);
            } else {
                ultimo = encontrado;
            }
        } else{
            Noh paizao = encontrado.getPai();
            if (hasLeft(paizao)){
                encontrado =  paizao.getEsq();
                ultimo = voltaesp(encontrado);
                
            } else {
                ultimo = paizao;
            }
        }
        
        downheap(raiz);
        // heap.set(ultimo, null);
        
        --size;

        return removed.getChave();
    }

    private Noh vaiesp(Noh no){
        System.out.println(no.getElemento().getChave() + " Chave vai");
        if (no == null){
            return no;
        }
        if (isRoot(no)){
            return no;
        }
        if (isExternal(no)){
            return no.getPai();
        } else {
            if(rightChild(no.getPai()) == no){
                return no;
            } else{
                return vai(no.getPai());
            }
        }
    }

    private Noh voltaesp(Noh no){
        System.out.println(no.getElemento().getChave() + " Chave volta");
        if (isExternal(no)){
            return no;
        }

        if (!hasLeft(no)){
            return no;
        }
        else {
            return volta(no.getDir());
            
        }
    }

    private void downheap(Noh no){
        
        Noh esq, dir, menor;

        if (hasLeft(no)){
            esq = no.getEsq();
            if (hasRight(no)){
                dir = no.getDir();

                if ((esq.getElemento()).getChave() > (dir.getElemento()).getChave()){
                    menor = dir;
            
                } else{
                    menor = esq;                  
                }
            } else {
                menor = esq;
            }
        
            while (isInternal(no) && (no.getElemento()).getChave() > (menor.getElemento()).getChave()){
                if ((menor.getElemento()).getChave() < (no.getElemento()).getChave()){
                        Item sub = no.getElemento();
                        no.setElemento(menor.getElemento());
                        menor.setElemento(sub);
                    }
                    
                no = menor;

                if (hasLeft(no)){
                    esq = no.getEsq();
                    if (hasRight(no)){
                        dir = no.getDir();

                        if ((esq.getElemento()).getChave() > (dir.getElemento()).getChave()){
                            menor = dir;
                    
                        } else{
                            menor = esq;
                        }
                    } else {
                        menor = esq;
                    }
                }
            }
        }
        
    }

    public void mostrar(){
        
        Item matriz[][] = new Item[height(root())+1][size()];
        visuals(matriz, root());
        this.num = 0;

        for (int i = 0; i < height(root())+1; i++){
            for (int j = 0; j < size(); j++){
                if (matriz[i][j] == null){
                    System.out.print(" ");
                } else {
                    System.out.print(matriz[i][j].getChave() + "   ");
                }
            }
            System.out.println("");
        }
    }

    private void visuals(Item[][] ob, Noh no){
        if (hasLeft(no)){
            visuals(ob, leftChild(no));
        }
        // System.out.println(this.num);
        ob[depth(no)][this.num] = no.getElemento();
        ++this.num;
        if (hasRight(no)){
            visuals(ob, rightChild(no));
        }
    }
}