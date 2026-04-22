public class DubNo{
    private Object elemento;
    private DubNo proximo;
    private DubNo anterior;
    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object o){
        elemento = o;
    }
    public void setNext(DubNo o){
        proximo = o;
    }

    public void setPrev(DubNo o){
        anterior = o;
    }
    public DubNo getNext(){
        return proximo;
    }

    public DubNo getPrev(){
        return anterior;
    }
}