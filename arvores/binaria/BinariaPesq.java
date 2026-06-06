import java.util.Iterator;
import java.util.ArrayList;

public class BinariaPesq implements InterfaceBinaria{
    private int num = 0;
    private No raiz;
    private int tam;


    public BinariaPesq(Object ra){
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
        if (isEmpty()){
            return 0;
        }
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

    public Object find(Object ele){
        No achado = treesearch(ele, root());
        if (achado.getElemento() != ele){
            return "Não encontrado";
        }
        return achado.getElemento();
    }

    public void insert(Object ele){
        No comperator = treesearchin(ele, root());
        
        if ((Integer)ele > (Integer)comperator.getElemento()){
                No novNo = new No(comperator, ele);
                comperator.setDir(novNo);
            } else {
                No novNo = new No(comperator, ele);
                comperator.setEsq(novNo);
            }
        tam++;
    }

    public void remove(No no){
        if (isEmpty()){
            System.out.println("Tá vazio");
        }
        if (isExternal(no)){
            if (isRoot(no)){
                raiz = null;
            } else{
                if ((no.getPai()).getEsq() == no){
                    (no.getPai()).setEsq(null);   
                } else {
                    (no.getPai()).setDir(null);   
                }
            }
            
        } else{
            System.out.println(no.getElemento() + "Raiz");
            if (hasRight(no)){
                No sucessor = no.getDir();
                
                while (hasLeft(sucessor)) {
                    sucessor = sucessor.getEsq();
                }
                
                replace(no, sucessor.getElemento());
                
                if (hasRight(sucessor)){
                    if (isRoot(sucessor.getPai())){
                        (sucessor.getPai()).setDir(sucessor.getDir());
                        (sucessor.getDir()).setPai(sucessor.getPai());    
                    }else {
                        (sucessor.getPai()).setEsq(sucessor.getDir());
                        (sucessor.getDir()).setPai(sucessor.getPai());
                    }

                }else{
                    System.out.println(sucessor.getElemento() + "Sucessor");
                    if (isRoot(sucessor.getPai())){
                        (sucessor.getPai()).setDir(null);
                    }else{
                        (sucessor.getPai()).setEsq(null);
                    }
                    
                }
                sucessor.setPai(null);
                sucessor.setDir(null);
            } else{
                System.out.println((no.getEsq()).getElemento() + "Sucessor");
                if (isRoot(no)){
                    raiz = no.getEsq();
                    raiz.setPai(null);
                } else{
                    (no.getPai()).setEsq(no.getEsq());
                    (no.getEsq()).setPai(no.getPai());
                }
                no.setEsq(null);
                no.setPai(null);
            }
            
        }
        tam--;
    }

    private No treesearch(Object ele, No no){
        if (isExternal(no)){
            return no;
        }

        if ((Integer)ele < (Integer)no.getElemento()){
            return treesearch(ele, no.getEsq());
        } else {
            if (ele == no.getElemento()){
                return no;
            } else {
                return treesearch(ele, no.getDir());
            }
        }
    }

    private No treesearchin(Object ele, No no){
        if (isExternal(no)){
            return no;
        } else{
            if ((Integer)ele > (Integer)no.getElemento()){
                if (hasRight(no)){
                    return treesearchin(ele,no.getDir());
                } else{
                    return no;
                }                                
            } else {
                if (hasLeft(no)){
                    return treesearchin(ele,no.getEsq());
                } else{
                    return no;
                }
            }
        }
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

    // MOSTRAR \\

    public void mostrar(){
        
        Object matriz[][] = new Object[height(root())+1][size()];
        visuals(matriz, root());
        this.num = 0;

        for (int i = 0; i < height(root())+1; i++){
            for (int j = 0; j < size(); j++){
                if (matriz[i][j] == null){
                    System.out.print("    ");
                } else {
                    System.out.print(matriz[i][j] + "    ");
                }
            }
            System.out.println("");
        }
    }

    private void visuals(Object[][] ob, No no){
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
