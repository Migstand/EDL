public class FiladoLanche implements Fila{
    private int ini = 0, fim = 0, cap, incre;
    private Object[] fil;

    public FiladoLanche(int cap, int incre){
        fil = new Object[cap];
        this.cap = cap;
        this.incre = incre;
    }

    public void enqueue(Object o){
        if (size() == cap - 1){ // encheu little college
            int novota;
            if (incre == 0){
                novota = cap*2;
            }
            else {
                novota = cap + incre;
            }
            Object[] neway = new Object[novota];
            int prim = ini;
            for (int fal = 0; fal < size(); fal++){
                neway[fal] = fil[prim];
                prim = (prim + 1) % cap;
            }
            fim = size(); //define o novo final
            ini = 0; // define o novo inicio
            cap = novota;
            fil = neway;
        }
        fil[fim] = o;
        fim = (fim + 1) % cap;
    }

    public Object dequeue() throws FilaVaziaExcecao{
        if(isEmpty()){
            throw new FilaVaziaExcecao("A Fila está vazia");
        }
        Object temp = fil[ini];
        ini = (ini + 1) % cap;
        return temp;
    }

    public int size(){
        return (cap - ini + fim) % cap;
    }

    public boolean isEmpty(){
        return fim == ini;
    }
    public Object first() throws FilaVaziaExcecao{
        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia!!!");
        }
        return fil[ini];
    }
    public int indexini(){ //Metodo auxiliar
        return ini;
    }
    public int indexfim(){ //Metodo auxiliar
        return fim;
    }
}