public class VectorArray implements Vetor{
    private Object[] vet; 
    private int cap, tam;

    public VectorArray(int cap){
        vet = new Object[cap];
        this.cap = cap; 
        this.tam = 0;
    }

    public Object eleAtRank(int r){
        return vet[r];
    }

    public Object replaceAtrank(int r, Object o){
        Object replaced = vet[r];
        vet[r] = o;
        return replaced;
    }

    public void insertAtRank(int r, Object o){
        if (size() == cap){
            grow();
        }

        for (int change = size(); change > r; change--){
            vet[change] = vet[change - 1];
        }
        vet[r] = o;
        tam += 1;
    }

    public Object removeAtrank(int r) throws VetorVazioExcecao{
        if (isEmpty()){
            throw new VetorVazioExcecao("O vetor está vazio!!!");
        }
        if (vet[r] == null){
            throw new VetorVazioExcecao("O vetor não existe!!!");
        }
        Object removed = vet[r];
        for (int change = r; change < size() - 1; change++){
            vet[change] = vet[change + 1];
        }
        tam -= 1;
        return removed;
    }

    public int size(){
        return tam;
    }

    public boolean isEmpty(){
        return tam == 0;
    }

    private void grow(){
        int novata;
        novata = cap*2;

        Object[] neway = new Object[novata];
        for (int fal = 0; fal < size(); fal++){
            neway[fal] = vet[fal];
        }
        cap = novata;
        vet = neway;   
    }
}