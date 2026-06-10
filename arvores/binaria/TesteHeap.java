import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class TesteHeap{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Item it = new Item(1, "pvc");
        Heap hop = new Heap(it);

        Item pod = hop.root().getElemento();
        System.out.println(pod.getChave());
        System.out.println(hop.size());

        //it = new Item(6, "Alo");
        //hop.insert(it);

        for (int i = 0; i < 5; i++){
            int obj = sc.nextInt();
            it = new Item(obj, "Alo" + i);
            hop.insert(it);
        }

        Iterator<Noh> pots = hop.nos();
        while (pots.hasNext()){
            Noh pot = (pots.next());
            System.out.print(pot.getElemento().getChave() + " ");
        }
        
        System.out.println(hop.size());

        System.out.println("");
        System.out.println(hop.removeMin());

        System.out.println("");
        System.out.println("-------------------------------------");
        pots = hop.nos();
        while (pots.hasNext()){
            Noh pot = (pots.next());
            System.out.print(pot.getElemento().getChave() + " ");
        }
        System.out.println(" , " + hop.size() + " Tamanho atual");
    }   
}