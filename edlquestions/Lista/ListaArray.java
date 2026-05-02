public class ListaArray{
    private int cap, tam;
    private Object[] lit;

    public ListaArray(int cap){
        this.cap = cap;
        this.tam = 0;
        lit = new Object[cap];
    }

    public int size(){
        return tam;
    }

    public boolean isEmpty(){
        return tam == 0;
    }

    public boolean isFirst(int n){
        return lit[n] == lit[0];
    }

    public boolean isLast(int n){
        return lit[n] == lit[size()-1];
    }

    public Object first(){
        return lit[0];
    }

    public Object last(){
        return lit[size()-1];
    }

    public Object before(int p){
        return lit[p-1];
    }

    public Object after(int p){
        return lit[p+1];
    }

    public Object replaceElement(int n, Object o){
        Object aux = lit[n];
        lit[n] = o;
        return aux;
    }

    public void swapElements(int n, int q){
        Object aux = lit[n];
        lit[n] = lit[q];
        lit[q] = aux;
    }

    public void insertBefore(int n, Object o){
        if (size() == cap-1){
            grow();
        }
        Object aux;
        for (int atlis = size(); atlis > n - 1; atlis--){
            aux = lit[atlis - 1];
            lit[atlis] = aux;
        }
        lit[n - 1] = o;
        tam +=1;
    }

    public void insertAfter(int n, Object o){
        if (size() == cap-1){
            grow();
        }
        Object aux;
        for (int atlis = size(); atlis > n + 1; atlis--){
            aux = lit[atlis - 1];
            lit[atlis] = aux;
        }
        lit[n+1] = o;
        tam +=1;
    }

    public void insertFirst(Object o){
        if (size() == cap-1){
            grow();
        }
        Object aux;
        for (int atlis = size(); atlis > 0; atlis--){
            aux = lit[atlis - 1];
            lit[atlis] = aux;
        }
        lit[0] = o;
        tam +=1;
    }

    public void insertLast(Object o){
        if (size() == cap-1){
            grow();
        }
        lit[size()] = o;
        tam +=1;
    }

    public Object remove(int n)throws ListaVaziaExcecao{
        if (isEmpty()){
            throw new ListaVaziaExcecao("A lista está vazia");
        }
        Object removed = lit[n];
        Object aux;
        for (int atlis = n; atlis < size(); atlis++){
            aux = lit[atlis + 1];
            lit[atlis] = aux;
        }
        tam -=1;
        return removed;
    }

    private void grow(){
        int novata;
        novata = cap*2;

        Object[] neway = new Object[novata];
        for (int fal = 0; fal < size(); fal++){
            neway[fal] = lit[fal];
        }
        cap = novata;
        lit = neway;  
    }
}