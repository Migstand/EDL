public class HeapArray{
    private Item[] heap;
    private int size;
    private int ultimo;
    private int cap;

    public HeapArray(Item elemento){
        cap = 5;
        heap = new Item[cap];
        heap[1] = elemento;
        size = 1;
        ultimo = 2;
    }
    public Item elemento(int i){
        return heap[i];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void insert(Item ele){
        if (size == cap){
            grow();
        }
        heap[ultimo] = ele;
        upheap(ultimo);
        ultimo++;
        size++;
    }

    private void upheap(int cha){
        while (heap[cha].getChave() < heap[cha/2].getChave()){
            Item sub = heap[cha];
            heap[cha] = heap[cha/2];
            heap[cha/2] = sub;

            cha = cha /2;
        }

    }

    public Item min(){
        return heap[1];
    }

    public int removeMin(){
        Item removed = min();
        Item menor = min();
        menor = heap[ultimo-1];
        heap[ultimo-1] = null;
        --ultimo;
        downheap(heap[1].getChave());

        --size;

        return removed.getChave();
    }

    private void downheap(int cha){
        
        Item esq = heap[cha*2];
        Item dir = heap[(cha*2)+1];
        Item menor;
        int ind;
        if (esq.getChave() > dir.getChave()){
            menor = dir;
            ind = (cha*2)+1;
        } else{
            menor = esq;
            ind = (cha*2);
        }

        while (heap[cha].getChave() > menor.getChave() && heap[cha*2] == null){

            esq = heap[cha*2];
            dir = heap[(cha*2)+1];

            if (dir == null){
                menor = esq;
            } else{
                if (esq.getChave() > dir.getChave()){
                    menor = dir;
                    ind = (cha*2)+1;
                } else{
                    menor = esq;
                    ind = (cha*2);
                }

            }
            
            if (menor.getChave() < heap[cha].getChave()){
                    Item sub = heap[cha];
                    heap[cha] = menor;
                    heap[ind] = sub;
                }
            
            cha = ind;
        }
    }
    private void grow(){
        int novata;
        novata = cap*2;

        Item[] neway = new Item[novata];
        for (int fal = 1; fal < size()+1; fal++){
            neway[fal] = heap[fal];
        }
        cap = novata;
        heap = neway;   
    }
}