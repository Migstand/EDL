public class VectorLig implements Vetor{
    private DubNo head, tail;
    private int tam;

    public VectorLig(){
        this.head = new DubNo();
        this.tail = new DubNo();
        this.head.setElemento(null);
        this.tail.setElemento(null);
        this.head.setNext(tail);
        this.tail.setPrev(head);
        this.tam = 0;
    }

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

    public Object removeAtrank(int r) throws VetorVazioExcecao{
        if (isEmpty()){
            throw new VetorVazioExcecao("O vetor está vazio!!!");
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

    public int size(){
        return tam;
    }

    public boolean isEmpty(){
        return tam == 0;
    }

    private DubNo AtRank(int rank){
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
}