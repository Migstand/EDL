public class FilaLigada implements Fila{
    No ini, fim;
    int tam;

    public FiladoLanche(){
        tam = 0;
    }

    public void enqueue(Object o){
        No novo = new No;
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

    public Object dequeue(){
        o = ini;
        ini = ini.getNext()
        tam -= 1;
        return o;
    }

    public int tamanho(){
        return tam;
    }

}