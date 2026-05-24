import java.util.ArrayList;
import java.util.Iterator;

public class No{
    private Object elemento;
    private No pai;
    private ArrayList<No> filhos = new ArrayList<No>();

    public No(No p, Object o){
        pai = p;
        elemento = o;   
    }

    public void setElemento(Object ele){
        elemento = ele;
    }

    public void setFilho(No fi){
        filhos.add(fi);
    }

    public No getPai(){
        return pai;
    }

    public Object getElemento(){
        return elemento;
    }

    public ArrayList<No> getFilhos(){
        return filhos;
    }

    public void tiraFilho(No no){
        filhos.remove(no);
    }
}