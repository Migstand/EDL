public class SequenciaLig implements Sequencia{
    private DubNo head, tail;
    // private DubNo[] vet;
    private int tam; //cap;

    public SequenciaLig(){
        
        // * CONSTRUTOR GERAL * \\
        this.tam = 0;
        
        //* CONSTRUTOR DO TAD VETOR *\\
        
        // this.cap = cap;
        // vet = new DubNo[cap];

        // * CONSTRUTOR DO TAD LISTA *\\
        this.head = new DubNo();
        this.tail = new DubNo();
        this.head.setElemento(null);
        this.tail.setElemento(null);
        this.head.setNext(tail);
        this.tail.setPrev(head);

    }
    
    // * GERAL * \\
    
    public int size(){
        return tam;
    }

    public boolean isEmpty(){
        return tam == 0;
    }

    //---------------------------------------\\
    // * VECTOR METHODS * \\

    public Object eleAtRank(int r){
        DubNo ele = AtRank(r);
        return ele.getElemento();
    }

    public Object replaceAtrank(int r, Object o){
        DubNo ele = AtRank(r);
        Object change = ele.getElemento();
        ele.setElemento(o);
        return change;
    }

    public void insertAtRank(int r, Object o){
        DubNo ele;
        if (size() == r){
            ele = tail;
        } else {
            ele = AtRank(r);
        }
        
        DubNo espaco = new DubNo();
        
        espaco.setNext(ele);
        espaco.setPrev(ele.getPrev());
        espaco.setElemento(o);

        (ele.getPrev()).setNext(espaco);
        ele.setPrev(espaco);

        tam += 1;
    }

    public Object removeAtrank(int r) throws SequenciaVaziaExcecao{
        if (isEmpty()){
            throw new SequenciaVaziaExcecao("O sequencia está vazia!!!");
        }

        DubNo ele = AtRank(r);
        Object removed = ele.getElemento();

        (ele.getPrev()).setNext(ele.getNext());
        (ele.getNext()).setPrev(ele.getPrev());

        ele.setPrev(null);
        ele.setNext(null);

        tam -= 1;
        return removed;
    }

    //---------------------------------------\\
    // * LIST METHODS * \\

    public boolean isFirst(DubNo n){
        return head.getNext() == n;

    }

    public boolean isLast(DubNo n){
        return tail.getNext() == n;
    }

    public DubNo first(){
        // DubNo ele = head.getNext();
        return head.getNext();
    }

    public DubNo last(){
        // DubNo ele = tail.getPrev();
        return tail.getPrev();
    }

    public DubNo before(DubNo p){
        // DubNo ele = p.getPrev();
        return p.getPrev();
    }
    public DubNo after(DubNo p){
        // DubNo ele = p.getNext();
        return p.getNext();
    }
    

    public Object replaceElement(DubNo n, Object o){
        Object replaced = n.getElemento();        
        n.setElemento(o);
        return replaced;
    }


    public void swapElements(DubNo n, DubNo q){
        Object swap = n.getElemento();
        n.setElemento(q.getElemento());
        q.setElemento(swap);
    }

    public DubNo insertBefore(DubNo n, Object o){

        DubNo novo_no = new DubNo();
        
        novo_no.setNext(n);
        novo_no.setPrev(n.getPrev());
        
        (n.getPrev()).setNext(novo_no);
        n.setPrev(novo_no);

        novo_no.setElemento(o);
        tam += 1;
        return novo_no;
    }

    public DubNo insertAfter(DubNo n, Object o){

        DubNo novo_no = new DubNo();
        
        novo_no.setNext(n.getNext());
        novo_no.setPrev(n);
        
        (n.getNext()).setPrev(novo_no);
        n.setNext(novo_no);

        novo_no.setElemento(o);
        tam += 1;
        return novo_no;
    }

    public void insertFirst(Object o){
        DubNo novo_no = new DubNo();
        
        novo_no.setNext(head.getNext());
        novo_no.setPrev(head);
        
        (head.getNext()).setPrev(novo_no);
        head.setNext(novo_no);
        tam += 1;
        novo_no.setElemento(o);
    }

    public void insertLast(Object o){
        DubNo novo_no = new DubNo();

        novo_no.setNext(tail);
        novo_no.setPrev(tail.getPrev());
        
        (tail.getPrev()).setNext(novo_no);
        tail.setPrev(novo_no);
        tam += 1;
        novo_no.setElemento(o);
    }


    public Object remove(DubNo n)throws SequenciaVaziaExcecao{
        if (isEmpty()){
            throw new SequenciaVaziaExcecao("A sequencia está vazia");
        }
        Object removed = n.getElemento();

        (n.getPrev()).setNext(n.getNext());

        (n.getNext()).setPrev(n.getPrev());

        n.setPrev(null);
        n.setNext(null);
        tam -= 1;
        return removed;
    }

    //---------------------------------------\\
    // * MÉTODOS PONTE DO TAD SEQUÊNCIA * \\

    public DubNo AtRank(int rank){
        DubNo novo_no;

        if (rank <= size()/2){
            novo_no = head.getNext();
            for (int ind = 0; ind < rank; ind++){
                novo_no = novo_no.getNext();
            }
        } else {
            novo_no = tail.getPrev();
            for (int ind = 0; ind < size() - rank - 1; ind++){
                novo_no = novo_no.getPrev();
            }
        }

        return novo_no;
    }

    public int rankOf(DubNo no){
        DubNo novo_no = head.getNext();
        int rank = 0;
        while (novo_no != no && novo_no != tail){
            novo_no = novo_no.getNext();
            rank++;
        }
        return rank;
    }

}