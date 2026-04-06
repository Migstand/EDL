public class No{
    private Object elemento;
    private No proximo;
    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object o){
        elemento = o;
    }
    public void setNext(No o){
        proximo = o;
    }
    public No getNext(){
        return proximo;
    }
}