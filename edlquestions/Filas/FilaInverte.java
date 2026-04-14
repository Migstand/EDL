public class FilaInverte implements Fila{
    private int ini = 0, fim = 0, cap, bswitch;
    private Object[] fil;

    public FilaInverte(int cap){
        fil = new Object[cap];
        this.cap = cap;
        bswitch = 0;
    }

    public void enqueue(Object o){
        if (bswitch == 0){
            if (size() == cap - 1){ // encheu little college
                int novata;
                novata = cap*2;

                Object[] neway = new Object[novata];
                int prim = ini;
                for (int fal = 0; fal < size(); fal++){
                    neway[fal] = fil[prim];
                    prim = (prim + 1) % cap;
                }
                fim = size(); //define o novo final
                ini = 0; // define o novo inicio
                cap = novata;
                fil = neway;
            }
            fil[fim] = o;
            fim = (fim + 1) % cap;

            if (size() == cap/3 ){
                int novata;
                novata = cap/2;

                Object[] neway = new Object[novata];
                int prim = ini;
                for (int fal = 0; fal < size(); fal++){
                    neway[fal] = fil[prim];
                    prim = (prim + 1) % cap;
                }
                fim = size(); //define o novo final
                ini = 0; // define o novo inicio
                cap = novata;
                fil = neway;
            }
        } else {
            if (size() == cap - 1){ // encheu little college
                int novata;
                novata = cap*2;

                Object[] neway = new Object[novata];
                int ult = fim;
                for (int fal = 0; fal < size(); fal++){
                    neway[fal] = fil[ult];
                    ult = (ult + 1) % cap;
                }
                cap = novata;
                fim = cap;
                ini = size() - 1;
                fil = neway;
            }
            fil[fim] = o;
            fim = (fim - 1 + cap) % cap;

            if (size() == cap/3){
                int novata;
                novata = cap/2;

                Object[] neway = new Object[novata];
                int ult = fim;
                for (int fal = 0; fal < size(); fal++){
                    neway[fal] = fil[ult];
                    ult = (ult + 1) % cap;
                }
                cap = novata;
                fim = cap;
                ini = size() - 1;
                fil = neway;
            }
        }
    }

    public Object dequeue() throws FilaVaziaExcecao{
        if(isEmpty()){
            throw new FilaVaziaExcecao("A Fila está vazia");
        }
        Object temp = fil[ini];
        if (bswitch == 0){
            ini = (ini + 1) % cap;
            if (size() == cap/3 ){
                int novata;
                novata = cap/2;

                Object[] neway = new Object[novata];
                int prim = ini;
                for (int fal = 0; fal < size(); fal++){
                    neway[fal] = fil[prim];
                    prim = (prim + 1) % cap;
                }
                fim = size(); //define o novo final
                ini = 0; // define o novo inicio
                cap = novata;
                fil = neway;
            }
        } else {
            ini = (ini - 1 + cap) % cap;
            if (size() == cap/3){
                int novata;
                novata = cap/2;

                Object[] neway = new Object[novata];
                int ult = fim;
                for (int fal = 0; fal < size(); fal++){
                    neway[fal] = fil[ult];
                    ult = (ult + 1) % cap;
                }
                cap = novata;
                fim = cap;
                ini = size() - 1;
                fil = neway;
            }
        }
        return temp;
        
    }
    public void switche(){
        bswitch = (bswitch + 1) % 2;
        int aux = ini;
        if (bswitch == 1){
            ini = (fim - 1 + cap) % cap;
            fim = (aux - 1 + cap) % cap;
        } else{
            ini = (fim + 1) % cap;
            fim = (aux + 1) % cap;
        }
        // int new_fim = ini;
        // int new_ini = fim;

        // for (int loop = 0; loop < size() - 1; loop++){
        //     aux = ini;
        //     fil[ini] = fil[fim];
        //     fil[fim] = fil[aux];
        //     ini += 1;
        //     fim += 1;
        // }
        // ini = new_ini;
        // fim = new_fim;
    }
    public int size(){
        if (bswitch == 0){
            return (cap - ini + fim) % cap;
        }else{
            return (cap + ini - fim) % cap;
        }
    }

    public boolean isEmpty(){
        return fim == ini;
    }
}