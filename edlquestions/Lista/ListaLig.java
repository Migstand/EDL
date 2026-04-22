public class ListaLig implements Lista{
    private DubNo head, tail;

    public ListaLig(){
        this.head.setNext(tail);
        this.tail.setPrev(head); 
    }
}