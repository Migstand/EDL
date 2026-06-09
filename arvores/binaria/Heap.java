import java.util.ArrayList;

public class Heap{
    private No raiz;
    private int size;
    private No ultimo;

    public HeapArray(Item elemento){
        raiz = new No(null, elemento);
        ultimo = raiz;
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

    public void insert(Item ele){
        
        
        No encontrado = vai(ultimo);

        if (isRoot(encontrado)){
            if (hasRight(encontrado)){
                encontrado =  encontrado.getDir();
                encontrado = volta(encontrado);
                No novo = new No(encontrado, ele);
                if (hasLeft(encontrado)){
                    encontrado.setEsq(novo);
                } else{
                    encontrado.setDir(novo);
                }
            } else {
                if (hasLeft(encontrado)){
                    No novo = new No(encontrado, ele);
                    encontrado.setDir(novo);
                    ultimo = novo;        
                } else {
                    No novo = new No(encontrado, ele);
                    encontrado.setEsq(novo);
                    ultimo = novo;
                }
                
            }
        } else{
            No paizao = encontrado.getPai();
            if (hasRight(paizao)){
                encontrado =  paizao.getDir();
                encontrado = volta(encontrado);
                No novo = new No(encontrado, ele);
                if (hasLeft(encontrado)){
                    encontrado.setEsq(novo);
                } else{
                    encontrado.setDir(novo);
                }
            } else {
                if (hasLeft(paizao)){
                    No novo = new No(paizao, ele);
                    paizao.setDir(novo);
                    ultimo = novo;        
                } else {
                    No novo = new No(paizao, ele);
                    paizao.setEsq(novo);
                    ultimo = novo;
                }
                
            }
            ultimo = novo;
        }
        
        upheap(ultimo);
    
        size++;

    }

    private No vai(No no){
        if (isRoot(no)){
            return no;
        } else {
            return volta(no.getEsq());
        }
    }

    private No volta(No no){
        if (isExternal(no)){
            return no;
        } else {
            if(leftChild(no.getPai()) == no){
                return no;
            } else{
                return vai(no.getPai());
            }
        }
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

    private void upheap(No no){
        while (null != no.getPai() && (no.getElemento()).getChave() < ((no.getPai()).getElemento()).getChave()){
            
            Item sub = no.getElemento();
            no.setElemento((no.getPai()).getElemento());
            (no.getPai()).setElemento(sub);

            no = no.getPai();
        }

    }

    public Item min(){
        return raiz;
    }

    public int removeMin(){
        Item removed = min().getElemento();
        
        raiz.setElemento(ultimo.getElemento());
        No encontrado = vaiesp(ultimo);

        if (isRoot(encontrado)){
            if (hasLeft(encontrado)){
                encontrado =  encontrado.getEsq();
                ultimo = voltaesp(encontrado);
            } else {
                ultimo = encontrado;
            }
        } else{
            No paizao = encontrado.getPai();
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

    private No vaiesp(No no){
        if (isRoot(no)){
            return no;
        } else {
            return volta(no.getDir());
        }
    }

    private No voltaesp(No no){
        if (isExternal(no)){
            return no;
        } else {
            if(rightChild(no.getPai()) == no){
                return no;
            } else{
                return vai(no.getPai());
            }
        }
    }

    private void downheap(No no){
        
        Item esq = no.getEsq();
        Item dir = no.getDir();
        Item menor;
    
        if (esq.getChave() > dir.getChave()){
            menor = dir;
            
        } else{
            menor = esq;
            
        }

        while (isInternal(no) && (no.getElemento()).getChave() > menor.getChave()){
            if (menor.getChave() < (no.getElemento()).getChave()){
                    Item sub = no.getElemento();
                    no.setElemento(menor.getElemento());
                    menor.setElemento(sub);
                }
            
            cha = ind;

            if (cha*2 > size()){
                break;
            }
            esq = heap.get(cha*2);
            
            
            if ((cha*2)+1 > size()){    
                menor = esq;
                ind = (cha*2);
            } else{
                dir = heap.get((cha*2)+1);
                if (esq.getChave() > dir.getChave()){
                    menor = dir;
                    ind = (cha*2)+1;
                } else{
                    menor = esq;
                    ind = (cha*2);
                }

            }
        }
    }

}