import java.util.ArrayList;
public class HeapArray{
    private ArrayList<Item> heap;
    private int size;
    private int ultimo;
    private int cap;

    public HeapArray(Item elemento){
        this.heap = new ArrayList<>();
        heap.add(null);
        heap.add(elemento);
        size = 1;
        ultimo = 2;
    }
    public Item elemento(int i){
        return heap.get(i);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void insert(Item ele){
        //if (size == cap){
        //    grow();
        //}
        heap.add(ele);
        upheap(ultimo);
        ultimo++;
        size++;
    }

    private void upheap(int cha){
        while (cha !=1 && (heap.get(cha)).getChave() < (heap.get(cha/2)).getChave()){
            Item sub = heap.get(cha);
            heap.set(cha, heap.get(cha/2));
            heap.set(cha/2, sub);

            cha = cha /2;
        }

    }

    public Item min(){
        return heap.get(1);
    }

    public int removeMin(){
        Item removed = min();
        
        heap.set(1, heap.get(ultimo-1));
        --ultimo;
        
        downheap(1);
        // heap.set(ultimo, null);
        
        --size;

        return removed.getChave();
    }

    private void downheap(int cha){
        
        Item esq = heap.get(cha*2);
        Item dir = heap.get((cha*2)+1);
        Item menor;
        int ind;
        if (esq.getChave() > dir.getChave()){
            menor = dir;
            ind = (cha*2)+1;
        } else{
            menor = esq;
            ind = (cha*2);
        }

        while ((cha*2) <= size() && (heap.get(cha)).getChave() > menor.getChave()){
            if (menor.getChave() < (heap.get(cha)).getChave()){
                    Item sub = heap.get(cha);
                    heap.set(cha, menor);
                    heap.set(ind, sub);
                }
            
            cha = ind;

            if (cha*2 > size()){
                break;
            }
            esq = heap.get(cha*2);
            
            
            if ((cha*2)+1 > size()){    
                menor = esq;
                ind = (cha*2);
            } else{
                dir = heap.get((cha*2)+1);
                if (esq.getChave() > dir.getChave()){
                    menor = dir;
                    ind = (cha*2)+1;
                } else{
                    menor = esq;
                    ind = (cha*2);
                }

            }
            
            
        }
    }
    // private void grow(){
    //     int novata;
    //     novata = cap*2;

    //     Item[] neway = new Item[novata];
    //     for (int fal = 1; fal < size()+1; fal++){
    //         neway[fal] = heap[fal];
    //     }
    //     cap = novata;
    //     heap = neway;   
    // }
}