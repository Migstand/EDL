public class FilaLigada implements Fila{
    No ini, fim;
    int tam;

    public FilaLigada(){
        tam = 0;
    }

    public void enqueue(Object o){
        No novo = new No();
        novo.setElemento(o);
        if (tam == 0){
            ini = novo;
            fim = novo;
        }
        else{
            fim.setNext(novo);
            fim = novo;
        }
        tam +=1;
    }

    public Object dequeue() throws FilaVaziaExcecao{
        if (isEmpty()){
            throw new FilaVaziaExcecao("A Fila está vazia");
        }
        Object o = ini.getElemento();
        ini = ini.getNext();
        return o;
    }

    public int (){
        return tam;
    }

    public boolean isEmpty(){
        return ini == null;
    }

}