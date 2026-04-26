public class ListaLig implements Lista{
    private DubNo head, tail;
    private int tam;

    public ListaLig(){
        this.head.setNext(tail);
        this.tail.setPrev(head);
        this.tam = 0;
    }

    public int size(){
        return tam;
    }
    public boolean isEmpty(){
        return tam == 0;
    }

    public boolean isFirst(DubNo n){
        return head.getNext() == n;

    }

    public boolean isLast(DubNo n){
        return tail.getNext() == n;
    }

    public Object first(){
        return head.getNext();
    }

    public Object last(){
        return tail.getPrev();
    }

    public Object before(DubNo p){
        return p.getPrev();
    }
    public Object after(DubNo p){
        return p.getNext();
    }
    

    public Object replaceElement(DubNo n, Object o){
        Object replaced = n.getElemento();        
        n.setElemento(o);
        return replaced;
    }


    public void swapElements(DubNo n, DubNo q){
        DubNo swap = n;
        n = q;
        q = swap;
    }

    public DubNo insertBefore(DubNo n, Object o){

        DubNo novo_no = new DubNo();
        
        novo_no.setNext(n);
        novo_no.setPrev(n.getPrev());
        
        (n.getPrev()).setNext(novo_no);
        n.setPrev(novo_no);

        return novo_no;
    }

    public DubNo insertAfter(DubNo n, Object o){

        DubNo novo_no = new DubNo();
        
        novo_no.setNext(n.getNext());
        novo_no.setPrev(n);
        
        (n.getNext()).setPrev(novo_no);
        n.setNext(novo_no);

        return novo_no;
    }

    public void insertFirst(Object o){
        DubNo novo_no = new DubNo();
        
        novo_no.setNext(head.getNext());
        novo_no.setPrev(head);
        
        (head.getNext()).setPrev(novo_no);
        head.setNext(novo_no);

        novo_no.setElemento(o);
    }

    public void insertLast(Object o){
        DubNo novo_no = new DubNo();

        novo_no.setNext(tail);
        novo_no.setPrev(tail.getPrev());
        
        (tail.getPrev()).setNext(novo_no);
        tail.setPrev(novo_no);

        novo_no.setElemento(o);
    }


    public Object remove(DubNo n)throws ListaVaziaExcecao{
        if (isEmpty()){
            throw new ListaVaziaExcecao("A lista está vazia");
        }
        Object removed = n.getElemento();

        (n.getPrev()).setNext(n.getNext());

        (n.getNext()).setPrev(n.getPrev());

        n.setPrev(null);
        n.setNext(null);

        return removed;
    } 
}