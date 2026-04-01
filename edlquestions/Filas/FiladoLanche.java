public class FiladoLanche{
    int ini = 0, fim = 0, cap, incre;
    Object O[];

    public FiladoLanche(int cap, int incre){
        O = new Object[cap];
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
                neway[fal] = O[prim];
                prim = (prim + 1) % cap;
            }
            fim = size(); //define o novo final
            ini = 0; // define o novo inicio
            cap = novota;
            O = neway;
        }
        O[fim] = o;
        fim = (fim + 1) % cap;
    }

    public Object dequeue(){
        if(isEmpty()){
            throw new FilaVaziaExcecao("A Pilha está vazia");
        }
        Object temp = O[ini];
        ini = (ini + 1) % cap;
        return temp;
    }

    public int size(){
        return (cap - ini + fim) % cap;
    }

    public boolean isEmpty(){
        return fim == ini;
    }
}