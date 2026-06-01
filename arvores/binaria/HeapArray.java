public class HeapArray{
    private Object[] heap;
    private int size;
    private int ultimo;

    public HeapArray(Item elemento){
        heap[1] = elemento;
        size = 1;
        ultimo = 2;
    }   

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void insert(Item ele){
        heap[ultimo] = ele;
        upheap(ultimo);
        ultimo++;
        size++;
    }

    private void upheap(int cha){
        while (heap[cha].getChave() < heap[cha/2].getChave()){
            Object sub = cha;
            heap[cha] = heap[cha/2];
            heap[cha/2] = sub;

            cha = cha /2;
        }

    }

    public int min(){
        return heap[1];
    }

    public int removeMin(){
        Object removed = min();
        Object menor = min();
        menor = heap[ultimo-1]
        heap[ultimo-1] = null;
        --ultimo;
        downheap(heap[1].getChave())

        --size;

        return removed.getChave();
    }

    private void downheap(int cha){
        
        Item esq = heap[cha*2];
        Item dir = heap[(cha*2)+1];

        if (esq.getChave() > dir.getChave()){
            Item menor = dir;
            int ind = (cha*2)+1;
        } else{
            Item menor = esq;
            int ind = (cha*2);
        }

        while (heap[cha].getChave() > menor.getChave() && heap[cha*2] == null){

            Item esq = heap[cha*2];
            Item dir = heap[(cha*2)+1];

            if (dir == null){
                Item menor = esq;
            } else{
                if (esq.getChave() > dir.getChave()){
                    Item menor = dir;
                    int ind = (cha*2)+1;
                } else{
                    Item menor = esq;
                    int ind = (cha*2);
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
}