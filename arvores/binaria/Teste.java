import java.util.Scanner;
public class Teste{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Item it = new Item(1, "pvc");
        HeapArray hop = new HeapArray(it);

        Item pod = hop.elemento(1);
        System.out.println(pod.getChave());
        System.out.println(hop.size());

        //it = new Item(6, "Alo");
        //hop.insert(it);

        for (int i = 0; i < 3; i++){
            int obj = sc.nextInt();
            it = new Item(obj, "Alo" + i);
            hop.insert(it);
        }
        for (int i = 1; i < hop.size()+1; i++){
            pod = (hop.elemento(i));
            System.out.print( pod.getChave() + " ");
        }
    }   
}