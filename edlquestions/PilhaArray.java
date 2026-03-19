public class PilhaArray implements Pilha{
    private int capacidade;
    private Object [] el;
    private int t;
    private int FC;
    
    // Init //
    public PilhaArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        t = -1;
        FC = crescimento;
        if (crescimento <= 0){
            FC = 0;
        }
        el = new Object[capacidade];
    }

    // * MÉTODOS * //
    public void push(Object o){
        if (t >= capacidade -1){
            if (FC == 0){
                capacidade*=2;
            }
            else {
                capacidade+=FC;
            }
            Object b[] = new Object[capacidade];
            for (int f = 0; f<a.length; f++){
                b[f] = el[f];
            }
            el = b;
        }
        a[++t] = o;
    }

    public Object pop() throws PilhaVaziaException{
        if(isEmpty()){
            throw new PilhaVaziaException("A pilha está vazia");
            Object r = a[t--];
            return r;
        }
    }

    public Object top() throws PilhaVaziaException{
        if(isEmpty()){
            throw new PilhaVaziaException("A pilha está vazia");
        }
        return el[t];
    }

    public boolean isEmpty(){
        return t == -1
    }

    public int size(){
        return t+1;
    }
}